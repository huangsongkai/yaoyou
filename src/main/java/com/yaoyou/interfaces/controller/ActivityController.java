package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.Activity;
import com.yaoyou.model.dataObject.ActivityItem;
import com.yaoyou.model.dataObject.ActivityShop;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.service.ActivityService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by song on 16/8/19.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    static{
        String basePath = "activity";
    }
    @Resource
    ActivityService activityService;

//    public ActivityController(BaseService baseService) {
//        super(baseService);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Activity view(@PathVariable int id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(Activity.class, activityService.get(id));
    }

    @RequestMapping(value = "/{id}/shops", method = RequestMethod.GET)
    @ResponseBody
    public List<ShopActivityDTO> viewShops(@PathVariable int id, HttpServletRequest request/*,Model model*/){
        return activityService.getShops(id);
    }

    @RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> viewItems(@PathVariable int id, HttpServletRequest request/*,Model model*/){
        return activityService.getItems(id);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> viewList(@PathVariable int pageNum, HttpServletRequest request/*,Model model*/){
        return activityService.getList(pageNum);
    }

    @RequestMapping(value = "/list/totalPage", method = RequestMethod.GET)
    @ResponseBody
    public int viewList(HttpServletRequest request/*,Model model*/){
        return activityService.totalPage();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Activity activity, HttpServletRequest request/*,Model model*/){
        Result result = activityService.add(activity);
        return result;
    }


    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Activity activity,HttpServletRequest request/*,Model model*/){
        int result = activityService.update(activity);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestBody Activity activity,HttpServletRequest request/*,Model model*/){
        int result = activityService.delete(activity.getActivityId());
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    @ResponseBody
    public Result addShop(@RequestBody ActivityShop activityShop, HttpServletRequest request/*,Model model*/){
        Result result = activityService.addShop(activityShop);
        return result;
    }
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseBody
    public Result addItem(@RequestBody ActivityItem activityItem, HttpServletRequest request/*,Model model*/){
        Result result = activityService.addItem(activityItem);
        return result;
    }

    @RequestMapping(value = "/page/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "activity/add";
    }
    @RequestMapping(value = "/page/edit", method = RequestMethod.GET)
    public String redirectEdit(){
        return "activity/edit";
    }
    @RequestMapping(value = "/page/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "activity/delete";
    }
    @RequestMapping(value = "/page/shop/add", method = RequestMethod.GET)
    public String redirectShopAdd(){
        return "activity/shop";
    }
    @RequestMapping(value = "/page/item/add", method = RequestMethod.GET)
    public String redirectItemAdd(){
        return "activity/item";
    }
}
