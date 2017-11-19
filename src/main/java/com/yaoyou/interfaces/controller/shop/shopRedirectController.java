package com.yaoyou.interfaces.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by song on 16/8/3.
 */
@Controller
@RequestMapping("/shop")
public class shopRedirectController {
    @RequestMapping("/add")
    public String redirectAdd(){
        return "shop/add";
    }

    @RequestMapping("/delete")
    public String redirectDelete(){
        return "shop/delete";
    }

    @RequestMapping("/comment/add")
    public String redirectCommentAdd(){
        return "/shop/comment";
    }



}
