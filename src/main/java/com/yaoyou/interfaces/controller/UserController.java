package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.UserDTO;
import com.yaoyou.service.UserService;
import com.yaoyou.util.DataTransfer;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by song on 16/7/19.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Resource
    UserService userService;

    @RequestMapping("/register")
    public String redirectRegister(){
        return "/user/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result registerSubmit(@RequestBody User user){
        if(ObjectNullCheck.check(user)){
            return newFaildResult("非法操作");
        }
        return userService.addUser(user);
    }

    @RequestMapping("/login")
    public String redirectLogin(){
        return "/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginSubmit(@RequestBody User user, HttpServletRequest request) {
        if (ObjectNullCheck.check(user)) {
            return newFaildResult("非法操作");
        }
        User userRetrieval = userService.getUserByPassword(user.getUserName(), user.getPassword());
        if (userRetrieval != null) {
            request.getSession().setAttribute("userId", userRetrieval.getUserId());
            return newResult(1,"登录成功", DataTransfer.toDestClass(userRetrieval, UserDTO.class));
        } else {
            return newFaildResult("登录失败，核对用户名密码");

        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return newSuccessResult("退出成功", null);
    }

    @RequestMapping(value = "/check/userName", method = RequestMethod.POST)
    @ResponseBody
    public Result isUserNameAvailable(@RequestBody User user){
        if(userService.existUserName(user.getUserName()))
            return newFaildResult("已经存在");
        return newSuccessResult("可以使用", null);
    }

    @RequestMapping(value = "/check/mobile", method = RequestMethod.POST)
    @ResponseBody
    public Result isMobileAvailable(@RequestBody User user){
        if(userService.existMobile(user.getMobile()))
            return newFaildResult("已经存在");
        return newSuccessResult("可以使用", null);
    }


    @RequestMapping(value = "/search/mobile/{mobile}", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO searchMobile(@PathVariable String mobile){
        User user = userService.searchUserByMobile(mobile);
        return ObjectNullCheck.getNonNullObject(UserDTO.class, DataTransfer.toDestClass(user, UserDTO.class));
    }

    @RequestMapping(value = "/search/userName/{userName}", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO searchName(@PathVariable String userName){
        User user = userService.searchUserByName(userName);
        return ObjectNullCheck.getNonNullObject(UserDTO.class, DataTransfer.toDestClass(user, UserDTO.class));
    }

    @RequestMapping(value = "/save/avatar", method = RequestMethod.POST)
    @ResponseBody
    public Result saveAvatar(@RequestBody User user){
        return newResult(userService.updateUser(user),"",null);
    }

    @RequestMapping("/check/userName")
    public String redirectCheckUserName(){
        return "/user/check/userName";
    }
    @RequestMapping("/check/mobile")
    public String redirectMobile(){
        return "/user/check/mobile";
    }

    @RequestMapping("/upload/avatar")
    public String redirectAvatar(){
        return "/user/avatar_upload";
    }
    }
