package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.UserDTO;
import com.yaoyou.util.DataTransfer;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by song on 16/7/21.
 */
@Controller
@RequestMapping("/")
public class RootController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Welcome!");
        return "hello";
    }
    @RequestMapping("/admin")
    public String modal(Model model){
        model.addAttribute("message", "Red romantic International Group");
        return "admin/adminindex";
    }
    @RequestMapping("/loginShop")
    public String loginShop(){
        System.out.print("qweqwewqeq");
        return "/managershop/loginmanagershop";
    }
}
