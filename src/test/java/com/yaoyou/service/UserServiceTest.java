package com.yaoyou.service;

import com.yaoyou.dao.UserMapper;
import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.UserDTO;
import com.yaoyou.util.DataTransfer;
import com.yaoyou.util.ObjectNullCheck;
import com.yaoyou.util.encrypt.PasswordSaltEncoder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/27.
 */
public class UserServiceTest {

    @Test
    public void testAddUser() throws Exception {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("/applicationContext.xml");
        //User user = (User) ctx.getBean("User");
        // user = new User();
        UserMapper userserMapper = (UserMapper) ctx.getBean("userMapper");
      //
      //  UserMapper userserMapper= new userserMapper();
        User user=userserMapper.selectByPrimaryKey("ff6342f4-095b-4bc0-86b2-f4c9a8eaec98");
        user.setPassword(PasswordSaltEncoder.encode("xxxxxx","balala"));
         ObjectNullCheck.getNonNullObject(UserDTO.class, DataTransfer.toDestClass(user, UserDTO.class));
       // userserMapper.updateByPrimaryKeySelective(user);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
    }
}