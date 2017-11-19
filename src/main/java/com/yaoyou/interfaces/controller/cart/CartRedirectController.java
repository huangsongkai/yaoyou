package com.yaoyou.interfaces.controller.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by song on 16/8/4.
 */
@Controller
@RequestMapping("/cart")
public class CartRedirectController {
    @RequestMapping("/add")
    public String redirectAdd(){
        return "/cart/add";
    }

}
