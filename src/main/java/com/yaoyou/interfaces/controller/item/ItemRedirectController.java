package com.yaoyou.interfaces.controller.item;

import com.yaoyou.model.dataObject.Item;
import com.yaoyou.service.ItemService;
import com.yaoyou.util.DataTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by song on 16/8/3.
 */
@Controller
@RequestMapping("/item")
public class ItemRedirectController {
    @Resource
    ItemService itemService;

    @RequestMapping("/add")
    public String redirectAdd(){
        return "item/add";
    }

    @RequestMapping("/delete")
    public String redirectDelete(){
        return "item/delete";
    }

    @RequestMapping("/modify")
    public String redirectModify(){
        return "item/modify";
    }

    @RequestMapping("/comment/add")
    public String redirectCommentAdd(){
        return "/shop/comment";
    }

    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public String viewItem(@PathVariable int id, Model model){
        Item item = itemService.selectById(id);
        model.addAttribute("item", DataTransfer.toJson(item));
        return "/item/view";
    }

}
