package com.yaoyou.service;

import com.sun.xml.internal.bind.v2.TODO;
import com.yaoyou.dao.UserMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dataObject.UserExample;
import com.yaoyou.model.dto.UserDTO;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.encrypt.PasswordSaltEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/7/12.
 */
@Service
public class UserService extends BaseService{
    @Resource
    UserMapper userMapper;


    private List<User> searchListByExample(UserExample userExample){
        return userMapper.selectByExample(userExample);
    }

    private User searchUserByExample(UserExample userExample){
        List<User> userList = userMapper.selectByExample(userExample);
        return userList.size() > 0?userList.get(0):null;
    }
    // TODO 改正密码加密规则 2016年8月27日15:16:20
    public Result addUser(User user) {
        Result addResult = new Result();
        if(existMobile(user.getMobile())){
            addResult.setStatus(-1);
            addResult.setMessage("手机号重复");
            return addResult;
        }
        if(existUserName(user.getUserName())){
            addResult.setStatus(-2);
            addResult.setMessage("用户名重复");
            return addResult;

        }
        user.setUserId(IdGenrator.next());
        user.setPassword(PasswordSaltEncoder.encode(user.getPassword(), user.getUserName()));
        user.setImg("");
        try {
            addResult.setStatus(userMapper.insert(user));
            addResult.setMessage(user.getUserId());
            return addResult;
        }catch (Exception e){
            logger.error(e);
        }
        return addResult;
    }

    public boolean existUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(userName);
        return searchListByExample(userExample).size() == 0?false:true;
    }

    public boolean existMobile(String mobile) {
        UserExample userExample = new UserExample();
        userExample.or().andMobileEqualTo(mobile);
        return searchListByExample(userExample).size() == 0?false:true;
    }

    public User getUserByPassword(String userName, String password) {
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(userName).andPasswordEqualTo(PasswordSaltEncoder.encode(password, userName));
        return searchUserByExample(userExample);
    }


    public String getUserIdByName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(userName);
        User user = searchUserByExample(userExample);
        return user == null? null:user.getUserId();
    }

    public String getUserIdByMobile(String mobile) {
        UserExample userExample = new UserExample();
        userExample.or().andMobileEqualTo(mobile);
        User user = searchUserByExample(userExample);
        return user == null? null:user.getUserId();
    }

    public List<User> getUserListByIdList(List<String> idList){
        UserExample userExample = new UserExample();
        userExample.or().andUserIdIn(idList);
        return  userMapper.selectByExample(userExample);
    }


    public User searchUserByName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(userName);
        User user = searchUserByExample(userExample);
        return user;
    }

    public User searchUserByMobile(String mobile) {
        UserExample userExample = new UserExample();
        userExample.or().andMobileEqualTo(mobile);
        User user = searchUserByExample(userExample);
        return user;
    }

    public int setUserImg(String userId, String url){
        User user = userMapper.selectByPrimaryKey(userId);
        user.setImg(url);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
