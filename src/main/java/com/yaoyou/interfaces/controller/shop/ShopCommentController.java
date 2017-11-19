package com.yaoyou.interfaces.controller.shop;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.ShopComment;
import com.yaoyou.service.ShopCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/3.
 */
@Controller
@RequestMapping("/shop")
public class ShopCommentController extends BaseController{
    @Resource
    ShopCommentService shopCommentService;


    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(@RequestBody ShopComment shopComment){
        int result = shopCommentService.addComment(shopComment);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyComment(@RequestBody ShopComment shopComment){
        int result = shopCommentService.updateComment(shopComment);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delComment(@RequestBody ShopComment shopComment){
        int result = shopCommentService.delComment(shopComment);
        return newResult(result, "", null);
    }

    @RequestMapping("/id/{shopInfoId}/comment/list/{pageNum}")
    @ResponseBody
    public List<ShopComment> getCommentsByShopId(@PathVariable String shopInfoId, @PathVariable int pageNum){
        List<ShopComment> shopCommentList = shopCommentService.getCommentsByShopId(shopInfoId, pageNum);
        return shopCommentList;
    }

    @RequestMapping("/id/{shopInfoId}/comment/list/total")
    @ResponseBody
    public int getCommentsTotalPage(@PathVariable String shopInfoId){
        int totalPage = shopCommentService.getCommentsTotalPage(shopInfoId);
        return totalPage;
    }

}
