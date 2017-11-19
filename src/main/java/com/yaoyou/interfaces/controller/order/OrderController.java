package com.yaoyou.interfaces.controller.order;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.interfaces.facade.OrderServiceFacade;
import com.yaoyou.model.dataObject.Item;
import com.yaoyou.model.dataObject.Order;
import com.yaoyou.model.dto.CartDTO;
import com.yaoyou.model.dto.OrderDTO;
import com.yaoyou.model.dto.OrderItemDTO;
import com.yaoyou.service.CartService;
import com.yaoyou.util.InvalidStorageException;
import com.yaoyou.service.ItemService;
import com.yaoyou.service.OrderService;
import com.yaoyou.util.DataTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by song on 16/8/5.
 */
//TODO 暂时不用订单与商品快照关联， 订单存取商品plain text
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Resource
    OrderService orderService;
    @Resource
    OrderServiceFacade orderServiceFacade;
    @Resource
    CartService cartService;

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String editOrder(@RequestBody List<CartDTO> cartDTOList, HttpServletRequest request, Model model) throws InvalidStorageException {
        String userId = safeGetUserId(request);
//        List<CartDTO> cartDTOList = cartService.selectCartDTOList(userId);
        model.addAttribute("cartDTOList", DataTransfer.toJson(cartDTOList));
        return "/order/confirm";
    }
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String editOrder( HttpServletRequest request, Model model) throws InvalidStorageException {
        String userId = safeGetUserId(request);
        List<CartDTO> cartDTOList = cartService.selectCartDTOList(userId);
        model.addAttribute("cartDTOList", DataTransfer.toJson(cartDTOList));
        return "/order/confirm";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrder(@RequestBody Order order, HttpServletRequest request) {
//        itemService.updateStorage(cartDTOList);
        int addressId = order.getAddId();
        try {
            orderService.addOrder(safeGetUserId(request), addressId);
        }catch (InvalidStorageException e){
            logger.error(e.getMessage());
            return newFaildResult("提交失败，库存不足");
        }
        return  newSuccessResult("订单添加成功", null);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> list(HttpServletRequest request){
       String userId = safeGetUserId(request);
        List<Order> orderList = orderService.getOrderListByUserId(userId);
        return orderList;
    }

    @RequestMapping(value = "/list/{userId}/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> list(@PathVariable String userId, @PathVariable int pageNum){
        List<Order> orderList = orderService.getOrderListByUserId(userId, pageNum);
        return orderList;
    }

    @RequestMapping(value = "/list/{userId}/totalPage", method = RequestMethod.GET)
    @ResponseBody
    public int totalPage(@PathVariable String userId){
        return orderService.getOrderTotalPage(userId);
    }

    @RequestMapping(value = "/list/page", method = RequestMethod.POST)
    public String listPage(HttpServletRequest request) {
        String userId = safeGetUserId(request);
        List<Order> orderList = orderService.getOrderListByUserId(userId);
        return  "order/list";
    }
    //  /submit/ff6342f4-095b-4bc0-86b2-f4c9a8eaec98/items/18:2-19:1/addressId/0

    @RequestMapping(value = "/submit/{userId}/items/{itemCountPairList}/addressId/{addressId}", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Order confirm(@PathVariable String userId, @PathVariable String itemCountPairList, @PathVariable int addressId) {
        try {
            Order order = orderServiceFacade.confirm(userId, itemCountPairList, addressId);
            return order;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/items/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderItemDTO> listItems(@PathVariable int orderId, HttpServletRequest request) {
        List<OrderItemDTO> itemDTOList = orderService.getOrderItemDTOByOderId(orderId);
        return  itemDTOList;
    }
}
