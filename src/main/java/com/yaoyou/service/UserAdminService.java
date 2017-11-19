package com.yaoyou.service;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yaoyou.dao.ShopAdminMapper;
import com.yaoyou.dao.ShopInfoMapper;
import com.yaoyou.dao.UserAdminMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.encrypt.PasswordSaltEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by song on 16/7/12.
 */
@SuppressWarnings("ALL")
@Service
public class UserAdminService extends BaseService{
    @Resource
    UserAdminMapper userAdminMapper;
    @Resource
    ShopInfoMapper shopInfoMapper;
    @Resource
    ShopAdminMapper shopAdminMapper;
        public UserAdmin getUserByPassword(String userName, String password) {
            UserAdminExample userAdminExample = new UserAdminExample();
            userAdminExample.or().andUserNameEqualTo(userName).andPasswordEqualTo(PasswordSaltEncoder.encode(password, userName));
        return searchUserByExample(userAdminExample);
    }
        private UserAdmin searchUserByExample(UserAdminExample userAdminExample){
        List<UserAdmin> userAdminList = userAdminMapper.selectByExample(userAdminExample);
        return userAdminList.size() > 0?userAdminList.get(0):null;
    }

    public Result addAdminToShopUser(ShopInfo shopInfo) {
        Result addResult = new Result();
        String shopinfoId=IdGenrator.next();
        shopInfo.setShopInfoId(shopinfoId);
        shopInfo.setState("state");
        shopInfo.setCreateUserName("admin");
        shopInfo.setCreateTime(new Date());
        shopInfo.setCreateUserId("ff6342f4-095b-4bc0-86b2-f4c9a8eaec98");
        //创建商店的时候自动创建一个商店管理员，管理的用户名为商店名，密码为admin
        ShopAdmin  shopAdmin = new ShopAdmin();
        shopAdmin.setUserId(IdGenrator.next());
        shopAdmin.setUserName(shopInfo.getShopName());
        shopAdmin.setPassword(PasswordSaltEncoder.encode("admin", shopInfo.getShopName()));//密码
        shopAdmin.setShopInfoId(shopinfoId);
        shopAdmin.setBirth("");
        shopAdmin.setEmail("");
        shopAdmin.setGender("");
        shopAdmin.setImg("");
        shopAdmin.setMobile("");
        shopAdmin.setCreateTime(new Date());

        try {
            addResult.setStatus(shopInfoMapper.insert(shopInfo));
            shopAdminMapper.insert(shopAdmin);
            return addResult;
        }catch (Exception e){
            logger.error(e); 
        }
        return addResult;
    }
//
//        public boolean existMobile(String mobile) {
//        UserExample userExample = new UserExample();
//        userExample.or().andMobileEqualTo(mobile);
//        return searchListByExample(userExample).size() == 0?false:true;
//    }

        private List<UserAdmin> searchListByExample(UserAdminExample userAdminExample){
        return userAdminMapper.selectByExample(userAdminExample);
    }

//    private UserAdminExample userAdminExample;
//
//

//

//

//
//    public boolean existUserName(String userName) {
//        UserExample userExample = new UserExample();
//        userExample.or().andUserNameEqualTo(userName);
//        return searchListByExample(userExample).size() == 0?false:true;
//    }
//

//

//
//
//    public String getUserIdByName(String userName) {
//        UserExample userExample = new UserExample();
//        userExample.or().andUserNameEqualTo(userName);
//        User user = searchUserByExample(userExample);
//        return user == null? null:user.getUserId();
//    }
//
//    public String getUserIdByMobile(String mobile) {
//        UserExample userExample = new UserExample();
//        userExample.or().andMobileEqualTo(mobile);
//        User user = searchUserByExample(userExample);
//        return user == null? null:user.getUserId();
//    }
//
//    public List<User> getUserListByIdList(List<String> idList){
//        UserExample userExample = new UserExample();
//        userExample.or().andUserIdIn(idList);
//        return  userAdminMapper.selectByExample(userExample);
//    }
//
//
//    public User searchUserByName(String userName) {
//        UserExample userExample = new UserExample();
//        userExample.or().andUserNameEqualTo(userName);
//        User user = searchUserByExample(userExample);
//        return user;
//    }
//
//    public User searchUserByMobile(String mobile) {
//        UserExample userExample = new UserExample();
//        userExample.or().andMobileEqualTo(mobile);
//        User user = searchUserByExample(userExample);
//        return user;
//    }
//
//    public int setUserImg(String userId, String url){
//        User user = userAdminMapper.selectByPrimaryKey(userId);
//        user.setImg(url);
//        return userAdminMapper.updateByPrimaryKeySelective(user);
//    }
//
//    public User getUserById(String userId) {
//        return userAdminMapper.selectByPrimaryKey(userId);
//    }
//
//    public int updateUser(User user) {
//        return userAdminMapper.updateByPrimaryKeySelective(user);
//    }
}
