package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.model.dto.UserDTO;

import com.yaoyou.service.ActivityService;
import com.yaoyou.service.ShopInfoService;
import com.yaoyou.service.UserAdminService;
import com.yaoyou.service.UserService;
import com.yaoyou.util.DataTransfer;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by Huang on 16/7/19.
 */
@Controller
@RequestMapping("/admin")
public class UserAdminController extends BaseController{
    @Resource
    UserAdminService userAdminService;//serves
    @Resource
    ActivityService activityService;
    @Resource
    ShopInfoService shopInfoService;

    //管理员后台管理
    @RequestMapping("/adminLogin")
    public String redirectAdminLogin(){
        return "/admin/adminlogin";
    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result adminLoginSubmit(@RequestBody User user, HttpServletRequest request) {
        if (ObjectNullCheck.check(user)) {
            return newFaildResult("非法操作");
        }
        UserAdmin userRetrieval = userAdminService.getUserByPassword(user.getUserName(), user.getPassword());
        if (userRetrieval != null) {
            request.getSession().setAttribute("userId", userRetrieval.getUserId());

            return newSuccessResult(userRetrieval.getUserId(), null);
        } else {
            return newFaildResult("登录失败，核对用户名密码");

        }
    }
    /**
     * 管理员为商店新建账号
     */
        @RequestMapping("/newShop")
        public String adminToShopRegister(){
            return "/admin/admintoshopregister";
        }
        @RequestMapping(value = "/newShop", method = RequestMethod.POST)
        @ResponseBody
        public Result adminToShopRegisterSubmit(@RequestBody ShopInfo shopInfo){
            if(ObjectNullCheck.check(shopInfo)){
                return newFaildResult("非法操作");
            }
            return userAdminService.addAdminToShopUser(shopInfo);
        }

    /**
     * 管理员创建活动
     * @return
     */
        @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
        public String addActivity(){
                return "admin/addactivity";
        }
        @RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
        @ResponseBody
        public Result add(@RequestBody Activity activity, HttpServletRequest request/*,Model model*/){
            Result result = activityService.add(activity);
            return result;
        }
    /**
     * 管理员查看商店列表
     * @return
     */
    @RequestMapping(value = "/listShop/{pageNum}",method = {RequestMethod.GET,RequestMethod.POST})
    public  String listShop(Model model,String shopName, @PathVariable int pageNum, HttpServletRequest request/*,Model model*/) throws UnsupportedEncodingException {
        int totalPage = shopInfoService.getTotalPage();
        if (pageNum==0||"".equals(pageNum)){
            pageNum=1;
        }
        if (totalPage<pageNum){
            pageNum=totalPage;
        }
        if (shopName!=null&&!("".equals(shopName))){
            shopName= URLDecoder.decode(shopName, "UTF-8");
            List<ShopInfo> shopInfoList= shopInfoService.getShopsByName(shopName,pageNum);
            System.out.print(shopInfoList);
            model.addAttribute("shopInfoList", DataTransfer.toJson(shopInfoList));
        }else{
            List<ShopInfo> shopInfoList = shopInfoService.getShopsByPageNum(pageNum);
            model.addAttribute("shopInfoList", DataTransfer.toJson(shopInfoList));
        }
        request.setAttribute("shopName",shopName);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("totalPage", totalPage);
        return "/admin/list_shop";
    }
}
