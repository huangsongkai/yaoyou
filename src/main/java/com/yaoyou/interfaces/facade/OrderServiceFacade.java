package com.yaoyou.interfaces.facade;

import com.yaoyou.model.dataObject.Order;
import com.yaoyou.service.OrderService;
import com.yaoyou.util.InvalidStorageException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/11.
 */
@Service
public class OrderServiceFacade {
    @Resource
    OrderService orderService;
    public Order confirm(String userId, String itemCountPairListStr, int addressId) {
        String[] pairs = itemCountPairListStr.split("-");
        List<ItemCountPair> itemCountPairList = new ArrayList<ItemCountPair>();
        String[] pair;
        for(String pairStr : pairs){
            pair = pairStr.split(":");
            ItemCountPair itemCountPair = new ItemCountPair();
            itemCountPair.setItemId(Integer.parseInt(pair[0]));
            itemCountPair.setCount(Integer.parseInt(pair[1]));
            itemCountPairList.add(itemCountPair);
        }
        return orderService.addOrder(userId, itemCountPairList, addressId);
    }
}