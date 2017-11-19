package com.yaoyou.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.yaoyou.dao.OrderItemMapper;
import com.yaoyou.dao.OrderItemSnapMapper;
import com.yaoyou.dao.OrderMapper;
import com.yaoyou.interfaces.facade.ItemCountPair;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.CartSnap;
import com.yaoyou.model.dto.OrderActivityDTO;
import com.yaoyou.model.dto.OrderItemDTO;
import com.yaoyou.util.InvalidStorageException;
import com.yaoyou.util.PageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/6.
 */
@Service
@Transactional
public class OrderService extends BaseService{
    @Resource
    OrderMapper orderMapper;
    //TODO 暂时取消跟SNAP关联
//    @Resource
//    OrderItemSnapMapper orderItemSnapMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    CartService cartService;
    @Resource
    ItemService itemService;

    private final int pageSize = 5;
//TODO 等到pc端需要提交订单再改
    @Deprecated
    @Transactional
    public int addOrder(String userId, int addId) {
        List<CartSnap> cartSnapList = cartService.getCartSnapList(userId);
        Order order = new Order();
        BigDecimal sum = new BigDecimal(0);
//        OrderItemSnap orderItemSnap = new OrderItemSnap();
        OrderItem orderItem = new OrderItem();
        order.setAddId(addId);
        order.setState("待支付");
        for(CartSnap cartSnap : cartSnapList){
            sum = sum.add(cartSnap.getPrice().multiply(BigDecimal.valueOf(cartSnap.getCount())));
        }
        order.setTotalPrice(sum);
        order.setUserId(userId);
        CartExample cartExample = new CartExample();
        orderMapper.insert(order);
        for(CartSnap cartSnap : cartSnapList){
//            orderItemSnap.setItemSnapId(itemService.getLatestItemSnapId(cartSnap.getItemId()));
//            orderItemSnap.setUserId(userId);
//            orderItemSnap.setOrderId(order.getOrderId());
//            orderItemSnapMapper.insert(orderItemSnap);
            //原子更新库存
            itemService.subStorageCount(cartSnap.getItemId(), cartSnap.getCount());
            //二次检查 竞争情况下 如果库存为负 冲突回滚
            if(itemService.selectById(cartSnap.getItemId()).getStorageCount()<0) {
                throw new InvalidStorageException();
            }
            cartExample.or().andUserIdEqualTo(userId).andItemIdEqualTo(cartSnap.getItemId());
            //逐条清除该购物车的该条目
            cartService.deleteCart(cartExample);
        }
        return 1;
    }

    public Order addOrder(String userId, List<ItemCountPair> itemCountPairList, int addressId){
        return addOrder(userId, itemCountPairList, addressId, "在线支付");
    }

//    @Transactional
    public Order addOrder(String userId, List<ItemCountPair> itemCountPairList, int addressId, String type) {
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        for(ItemCountPair itemCountPair : itemCountPairList){
            OrderItem orderItem = getOrderItemByOderId(itemCountPair.getItemId());
            orderItem.setCount(itemCountPair.getCount());
            orderItemList.add(orderItem);
        }

        Order order = new Order();
        order.setAddId(addressId);
        order.setState("待支付");
        order.setType(type);
        BigDecimal sum = new BigDecimal(0);
        int index = 0;
        for(OrderItem orderItem : orderItemList){
            sum = sum.add(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getCount())));
        }
        order.setTotalPrice(sum);
        order.setUserId(userId);
        CartExample cartExample = new CartExample();
        orderMapper.insert(order);
        index = 0;
        for(OrderItem orderItem : orderItemList){
            orderItem.setOrderId(order.getOrderId());
            orderItemMapper.insert(orderItem);
            //原子更新库存
            itemService.subStorageCount(orderItem.getItemId(), orderItem.getCount());
            //二次检查 竞争情况下 如果库存为负 冲突回滚
            if(itemService.selectById(orderItem.getItemId()).getStorageCount()<0) {
                throw new InvalidStorageException();
            }
            cartExample.or().andUserIdEqualTo(userId).andItemIdEqualTo(orderItem.getItemId());
            //逐条清除该购物车的该条目
            cartService.deleteCart(cartExample);
            index++;
        }
        return order;
    }

    //联合活动信息 最终确定OrderItem
    private OrderItem getOrderItemByOderId(int itemId) {
        OrderActivityDTO orderActivityDTO = orderMapper.selectOrderItemUnionActivityInfo(itemId);
        OrderItem orderItem = new OrderItem();
        try {
            BeanUtils.copyProperties(orderItem, orderActivityDTO);
            if(orderActivityDTO.getActivityPrice() != null)
                orderItem.setPrice(orderActivityDTO.getActivityPrice());
            if(orderActivityDTO.getActivityPoint() != null)
                orderItem.setPoint(orderActivityDTO.getActivityPoint());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return orderItem;
    }


    public List<Order> getOrderListByUserId(String userId) {
        OrderExample orderExample = new OrderExample();
        orderExample.or().andUserIdEqualTo(userId);
        orderExample.setOrderByClause("ORDER_ID desc");
        return orderMapper.selectByExample(orderExample);
    }

    public List<OrderActivityDTO> getOrderListByShopInfoFprPage(String shopInfoId,int pageNum) {
        return orderMapper.selectOrderByShopInfoFroPage(shopInfoId,(pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }


    public List<Order> getOrderListByUserId(String userId, int pageNum) {
        OrderExample orderExample = new OrderExample();
        orderExample.or().andUserIdEqualTo(userId);
        String paginationClause = PageUtil.genPaginationClause(pageNum, pageSize);
        String tmp = "ORDER_ID desc," + paginationClause;
        System.out.println(tmp);
        orderExample.setOrderByClause("ORDER_ID desc " + paginationClause);
        return orderMapper.selectByExample(orderExample);
    }

    public int getOrderTotalPage(String userId) {
        OrderExample orderExample = new OrderExample();
        orderExample.or().andUserIdEqualTo(userId);
        int total = orderMapper.countByExample(null);
        return PageUtil.getPageNum(total, pageSize);
    }

    public List<OrderItemDTO> getOrderItemDTOByOderId(int orderId) {
        return orderMapper.selectOrderItemDTO(orderId);
    }
}
