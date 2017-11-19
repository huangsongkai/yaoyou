package com.yaoyou.service;

import com.yaoyou.dao.CartDTOMapper;
import com.yaoyou.dao.CartMapper;
import com.yaoyou.interfaces.facade.ItemCountPair;
import com.yaoyou.model.dataObject.Cart;
import com.yaoyou.model.dataObject.CartExample;
import com.yaoyou.model.dto.CartDTO;
import com.yaoyou.model.dto.CartSnap;
import com.yaoyou.model.dto.ItemDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/4.
 */

//TODO 购物车的存储暂时放在移动端，下面的cartDTO itemDTO关系 需要进一步捋顺
@Service
public class CartService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private CartDTOMapper cartDTOMapper;
    @Resource
    private ItemService itemService;


    public int addCart(Cart cart) {
        if(cart.getItemId() == null||cart.getUserId()==null)
            return 0;

        CartExample cartExample = new CartExample();
        cartExample.or().andUserIdEqualTo(cart.getUserId()).andItemIdEqualTo(cart.getItemId());
        int result;
        List<Cart> cartList = cartMapper.selectByExample(cartExample);
        if(cartList.size() == 0){
            result = cartMapper.insert(cart);
        }else {
            Cart exitCart = cartList.get(0);
            cart.setCount(cart.getCount()+exitCart.getCount());
            result = cartMapper.updateByExampleSelective(cart, cartExample);
        }
        return result;
    }

    public List<Cart> viewCartByUserId(String userId) {
        CartExample cartExample = new CartExample();
        cartExample.or().andUserIdEqualTo(userId);
        return cartMapper.selectByExample(cartExample);
    }

    public int updateCart(Cart cart) {

        CartExample cartExample = new CartExample();
        cartExample.or().andItemIdEqualTo(cart.getItemId()).andUserIdEqualTo(cart.getUserId());
        if(cart.getCount() == 0){
            return deleteCart(cartExample);
        }
        return cartMapper.updateByExampleSelective(cart, cartExample);
    }

    public int deleteCart(Cart cart) {
        CartExample cartExample = new CartExample();
        cartExample.or().andItemIdEqualTo(cart.getItemId()).andUserIdEqualTo(cart.getUserId());
        return cartMapper.deleteByExample(cartExample);
    }

    public int deleteCart(CartExample cartExample) {
        return cartMapper.deleteByExample(cartExample);
    }

    public int updateCartList(List<Cart> cartList) {
        int result = 0;
        for(Cart cart : cartList){
            result += updateCart(cart);
        }
        return result;
    }

    public List<CartDTO> selectCartDTOList(String userId) {
        return cartDTOMapper.selcetByUserId(userId);
    }

    public List<CartSnap> getCartSnapList(String userId){
        return cartMapper.selectCartSnapByUserId(userId);
    }

    public List<CartDTO> selectCartDTOList(int[] ids) {
        List<CartDTO> cartDTOList = new ArrayList<CartDTO>();
        for(int id : ids){
            cartDTOList.add(cartDTOMapper.selectByItemId(ids[0]));
        }
        return cartDTOList;
    }

    public List<ItemDTO> selectItemDTOList(int[] ids) {
        List<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
        for(int id : ids){
            itemDTOList.add(itemService.selectItemDTOById(id));
        }
        return itemDTOList;
    }
}
