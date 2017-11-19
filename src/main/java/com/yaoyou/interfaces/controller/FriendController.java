package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.UserDTO;
import com.yaoyou.service.FriendService;
import com.yaoyou.util.DataTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/17.
 */
@Controller
@RequestMapping("/friend")
public class FriendController extends BaseController {
    @Resource
    FriendService friendService;
//暂时没做认证
    @RequestMapping("/apply/{userId}/byId/{friendId}")
    @ResponseBody
    public Result addFriendById(@PathVariable String userId, @PathVariable String friendId){

        if(friendService.existsFriendId(userId, friendId))
            return newFaildResult("添加失败，已经添加过！");
        int result = friendService.addFriendById(userId, friendId);
        if(result > 0){
            return newSuccessResult("添加成功", null);
        }else
            return newFaildResult("添加失败，核对用户名手机号");
    }

    @RequestMapping(value = "/apply/{userId}/byId/{friendId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delFriendById(@PathVariable String userId, @PathVariable String friendId){

        int result = friendService.delFriendById(userId, friendId);
        if(result > 0){
            return newSuccessResult("删除成功", null);
        }else
            return newFaildResult("删除失败，核对用户名手机号");
    }

    @RequestMapping("/apply/{userId}/byName/{friendUserName}")
    @ResponseBody
    public Result addFriendByName(@PathVariable String userId, @PathVariable String friendUserName){
        if(friendService.existsFriendName(userId, friendUserName))
            return newFaildResult("添加失败，已经添加过！");
        int result = friendService.addFriendByName(userId, friendUserName);
        if(result > 0){
            return newSuccessResult("添加成功", null);
        }else
            return newFaildResult("添加失败，核对用户名手机号");
    }

    @RequestMapping("/apply/{userId}/byMobile/{mobile}")
    @ResponseBody
    public Result addFriendByMobile(@PathVariable String userId, @PathVariable String mobile){
        if(friendService.existsFriendMobile(userId, mobile))
            return newFaildResult("添加失败，已经添加过！");
        int result = friendService.addFriendByMobile(userId, mobile);
        if(result > 0){
            return newSuccessResult("添加成功", null);
        }else
            return newFaildResult("添加失败，核对用户名手机号");
    }

    @RequestMapping("/list/{userId}")
    @ResponseBody
    public List<UserDTO> getList(@PathVariable String userId){
        List<User> userList = friendService.getListByUserId(userId);
        List<UserDTO> userDTOList = DataTransfer.toDestClassList(userList, UserDTO.class);
        return userDTOList;
    }

    @RequestMapping("/page/delete")
    public String redirectToDelete(){
        return "friend/delete";
    }

}
