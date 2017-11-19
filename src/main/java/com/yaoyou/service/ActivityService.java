package com.yaoyou.service;

import com.yaoyou.dao.ActivityItemMapper;
import com.yaoyou.dao.ActivityMapper;
import com.yaoyou.dao.ActivityShopMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/24.
 */
@Service
public class ActivityService extends BaseService {
    @Resource
    ActivityMapper activityMapper;
    @Resource
    ActivityShopMapper activityShopMapper;
    @Resource
    ActivityItemMapper activityItemMapper;

    public Result add(Activity activity) {
        return new Result(activityMapper.insert(activity),"",activity);
    }

    public int update(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    public int delete(Integer activityId) {
        return activityMapper.deleteByPrimaryKey(activityId);
    }

    public Activity get(int id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    public List<Activity> getList(int pageNum) {
        ActivityExample activityExample = new ActivityExample();
        activityExample.setOrderByClause("END_TIME DESC "+ PageUtil.genPaginationClause(pageNum));
        return activityMapper.selectByExample(activityExample);
    }

    public int totalPage() {
        return PageUtil.getPageNum(activityMapper.countByExample(null));
    }

    public Result addShop(ActivityShop activityShop) {
        int result = 0;
        try {
            result = activityShopMapper.insert(activityShop);
        }catch (Exception e){
            return new Result(result,"药店已经参加了活动",activityShop);
        }
        return new Result(result,"",activityShop);
    }

    public Result addItem(ActivityItem activityItem) {
        int result = 0;
        try {
            result = activityItemMapper.insert(activityItem);
        }catch (Exception e){
            return new Result(result,"该商品已经参加此活动",activityItem);
        }
        return new Result(result,"",activityItem);
    }

    public Integer getAvailableActivityIdByShopInfoId(String shopInfoId) {
        List<Integer> activityIdList = activityShopMapper.selectAvailableActivityIdByShopInfoId(shopInfoId);
        if(activityIdList.size() == 0 )
            return null;
        return activityIdList.get(0);
    }

    public List<ShopActivityDTO> getShops(int id) {
        return activityShopMapper.selectShopActivityDTO(id);
    }

    public List<ItemDTO> getItems(int id) {
        return activityItemMapper.selectItemDTO(id);
    }
}

