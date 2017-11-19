package com.yaoyou.interfaces.controller.medicine;

import com.yaoyou.interfaces.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by song on 16/8/3.
 */
@Controller
@RequestMapping("/medicine")
public class MedicineRedirectController extends BaseController {

    @RequestMapping("/add")
    public String redirectAdd(){
        return "medicine/add";
    }

    @RequestMapping("/delete")
    public String redirectDelete(){
        return "medicine/delete";
    }

    @RequestMapping("/comment/add")
    public String redirectCommentAdd(){
        return "/medicine/comment";
    }

}
