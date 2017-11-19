package com.yaoyou.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by song on 16/8/30.
 */
@Controller
@RequestMapping("/v")
public class VelocityController {
    @RequestMapping("")
    public String test(Model model){
        model.addAttribute("hello","world");
        return "test.vm";
    }

}
