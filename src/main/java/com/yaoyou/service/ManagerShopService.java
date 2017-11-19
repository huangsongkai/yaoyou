package com.yaoyou.service;

import com.yaoyou.dao.MedicineInfoMapper;
import com.yaoyou.dao.ShopAdminMapper;
import com.yaoyou.dao.ShopInfoMapper;
import com.yaoyou.dao.UserAdminMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.SearchDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.PageUtil;
import com.yaoyou.util.StringUtil;
import com.yaoyou.util.encrypt.PasswordSaltEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by song on 16/7/12.
 */
@SuppressWarnings("ALL")
@Service
public class ManagerShopService extends BaseService{
    @Resource
    UserAdminMapper userAdminMapper;
    @Resource
    ShopInfoMapper shopInfoMapper;
    @Resource
    ShopAdminMapper shopAdminMapper;
    @Resource
    MedicineInfoMapper medicineInfoMapper;
    @Resource
    MedicineInfoService medicineInfoService;
    @Resource
    ShopInfoService shopInfoService;
        public ShopAdmin getUserByPassword(String userName, String password) {
            ShopAdminExample shopAdminExample = new ShopAdminExample();
            shopAdminExample.or().andUserNameEqualTo(userName).andPasswordEqualTo(PasswordSaltEncoder.encode(password, userName));
        return searchUserByExample(shopAdminExample);
    }
        private ShopAdmin searchUserByExample(ShopAdminExample userShopExample){
        List<ShopAdmin> ShopAdminpList = shopAdminMapper.selectByExample(userShopExample);
        return ShopAdminpList.size() > 0?ShopAdminpList.get(0):null;
    }

    public Result addAdminToShopUser(ShopInfo shopInfo) {
        Result addResult = new Result();
        shopInfo.setShopInfoId(IdGenrator.next());
        shopInfo.setState("state");
        shopInfo.setCreateUserName("admin");
        shopInfo.setCreateTime(new Date());
        shopInfo.setCreateUserId("ff6342f4-095b-4bc0-86b2-f4c9a8eaec98");
        try {
            addResult.setStatus(shopInfoMapper.insert(shopInfo));
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


    public List<MedicineInfo> getMedicineByPageNum(int pageNum, String shopInfoId){
        return medicineInfoMapper.selectByLimitAndProductOrderBy((pageNum - 1) * PAGE_SIZE, PAGE_SIZE,shopInfoId);
    }

    public List<MedicineInfo> getMedicineByNameForPage(String productName, int pageNum, String shopInfoId) {
        return medicineInfoMapper.selectByLimitAndProductOrderByForproductName((pageNum - 1) * PAGE_SIZE, PAGE_SIZE,shopInfoId,productName);
    }
}
