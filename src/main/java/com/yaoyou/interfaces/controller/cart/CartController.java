package com.yaoyou.interfaces.controller.cart;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.facade.CartServiceFacade;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/4.
 *
 * TODO 表单提价和用户检查，后期修改成注解或者AOP或者Security相关框架
 *
 * ***/
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
    @Resource
    CartService cartService;
    @Autowired
    CartServiceFacade cartServiceFacade;

    @RequestMapping(value = "/items/{itemIdList}", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> viewCartByUserIdItemList(@PathVariable String itemIdList/*,Model model*/){
        List<ItemDTO> ItemDTOList = cartServiceFacade.getItemDTOList(itemIdList);
        return ItemDTOList;
    }

    /*@RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<CartDTO> viewCart(HttpServletRequest request){
//        return cartService.viewCartByUserId(userId);
        String userId = safeGetUserId(request);
        List<CartDTO> cartDTOList = cartService.selectCartDTOList(userId);
        return cartDTOList;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addCart(@RequestBody Cart cart, HttpServletRequest request*//*,Model model*//*){
        CheckResult checkResult = checkFormAndGetUserId(request, cart);
        if(!checkResult.getState())
            return newFaildResult(checkResult.getMsg());
        cart.setUserId(checkResult.getUserId());
        int result = cartService.addCart(cart);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateCart(@RequestBody Cart cart,HttpServletRequest request*//*,Model model*//*){
        CheckResult checkResult = checkFormAndGetUserId(request, cart);
        if(!checkResult.getState())
            return newFaildResult(checkResult.getMsg());
        cart.setUserId(checkResult.getUserId());

        int result = cartService.updateCart(cart);
        return newResult(result, "", null);
    }


    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteCart(@RequestBody Cart cart, HttpServletRequest request*//*,Model model*//*){
        CheckResult checkResult = checkFormAndGetUserId(request, cart);
        if(!checkResult.getState())
            return newFaildResult(checkResult.getMsg());
        cart.setUserId(checkResult.getUserId());

        int result = cartService.deleteCart(cart);
        return newResult(result, "", null);
    }*/




    /*@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCart(HttpServletRequest request, Model model){
        String userId = safeGetUserId(request);
        List<CartDTO> cartDTOList = cartService.selectCartDTOList(userId);
        model.addAttribute("cartDTOList", DataTransfer.toJson(cartDTOList));
        return "cart/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    @ResponseBody
    public Result editCart(HttpServletRequest request, @RequestBody List<CartDTO> cartDTOList, Model model){
        String userId = safeGetUserId(request);
        List<Cart> cartList = DataTransfer.toDestClassList(cartDTOList, Cart.class);
        for(Cart cart : cartList)
            cart.setUserId(userId);
        int result = cartService.updateCartList(cartList);
        return newResult(result, "更新完毕", null);
    }*/


}
