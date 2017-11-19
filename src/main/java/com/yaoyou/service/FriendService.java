package com.yaoyou.service;

import com.yaoyou.dao.FriendMapper;
import com.yaoyou.model.dataObject.Friend;
import com.yaoyou.model.dataObject.FriendExample;
import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/17.
 */
@Service
public class FriendService {

    @Resource
    FriendMapper friendMapper;
    @Resource
    UserService userService;

    public boolean existsFriendId(String userId, String friendId) {
        FriendExample friendExample = new FriendExample();
        friendExample.or().andUserIdEqualTo(userId).andFriendIdEqualTo(friendId);
        return friendMapper.selectByExample(friendExample).size() > 0 ? true : false;
    }

    public boolean existsFriendName(String userId, String friendUserName) {
        String friendId = userService.getUserIdByName(friendUserName);
        return existsFriendId(userId, friendId);
    }

    public boolean existsFriendMobile(String userId, String mobile) {
        String friendId = userService.getUserIdByMobile(mobile);
        return existsFriendId(userId, friendId);
    }

    @Transactional
    public int addFriendById(String userId, String friendId) {
        Friend friend = new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        friend.setVerified(true);

        Friend reverse = new Friend();
        reverse.setUserId(friendId);
        reverse.setVerified(true);
        reverse.setFriendId(userId);

        int result;
        result = friendMapper.insert(friend);
        result += friendMapper.insert(reverse);

        return result;
    }

    public int addFriendByName(String userId, String friendUserName) {
        String friendId = userService.getUserIdByName(friendUserName);
        return addFriendById(userId, friendId);
    }

    public int addFriendByMobile(String userId, String mobile) {
        String friendId = userService.getUserIdByMobile(mobile);
        return addFriendById(userId, friendId);
    }

    public List<User> getListByUserId(String userId) {
        FriendExample friendExample = new FriendExample();
        friendExample.or().andUserIdEqualTo(userId);
        List<Friend> friendList = friendMapper.selectByExample(friendExample);
        List<String> userIdList = new ArrayList<String>();
        for(Friend friend : friendList)
            userIdList.add(friend.getFriendId());
        return userService.getUserListByIdList(userIdList);
    }

    public int delFriendById(String userId, String friendId) {
        FriendExample friendExample = new FriendExample();
        friendExample.or().andUserIdEqualTo(userId).andFriendIdEqualTo(friendId);
        friendMapper.deleteByExample(friendExample);
        friendExample = new FriendExample();
        friendExample.or().andUserIdEqualTo(friendId).andFriendIdEqualTo(userId);
        friendMapper.deleteByExample(friendExample);
        return 1;
    }
}
