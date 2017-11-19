package com.yaoyou.interfaces.facade;

import com.yaoyou.model.dto.CartDTO;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/11.
 */
@Service
public class CartServiceFacade {
    @Resource
    CartService cartService;
    /*public List<CartDTO> getCartDTOList(String itemIdList) {
        String[] idsString = itemIdList.split("-");
        int[] ids = new int[idsString.length];
        int index = 0;
        for(String str : idsString){
            try {
                ids[index++] = Integer.parseInt(str);
            }catch (Exception e){
                index--;
            }
        }
        return cartService.selectCartDTOList(ids);
    }*/

    public List<ItemDTO> getItemDTOList(String itemIdList) {

        String[] idsString = itemIdList.split("-");
        int[] ids = new int[idsString.length];
        int index = 0;
        for(String str : idsString){
            try {
                ids[index++] = Integer.parseInt(str);
            }catch (Exception e){
                index--;
            }
        }
        return cartService.selectItemDTOList(ids);
    }
}
