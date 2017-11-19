package com.yaoyou.service;

import com.yaoyou.dao.ShopCommentMapper;
import com.yaoyou.dao.ShopInfoMapperExt;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.PageUtil;
import com.yaoyou.util.StringUtil;
import com.yaoyou.util.gps.GPSComparator;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by song on 16/7/20.
 */
@Service
public class ShopInfoService extends BaseService{

    //松北区政府坐标126.561624,45.812998

    BigDecimal DEFAULT_GPS_X = new BigDecimal(126.561624);
    BigDecimal DEFAULT_GPS_Y = new BigDecimal(45.812998);


    @Resource
    ShopInfoMapperExt shopInfoMapperExt;
    @Resource
    ActivityService activityService;

    public List<ShopInfo> getAllShops(){
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        shopInfoExample.setOrderByClause("SEQ DESC, CREATE_TIME DESC");
        return shopInfoMapperExt.selectByExample(shopInfoExample);
    }

    public List<ShopInfo> getShopsByPageNum(int pageNum){
        return shopInfoMapperExt.selectByLimit((pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int addShopInfo(ShopInfo shopInfo){
        shopInfo.setShopInfoId(IdGenrator.next());
        return shopInfoMapperExt.insert(shopInfo);
    }

    public int deleteShopInfo(ShopInfo shopInfo){
        return shopInfoMapperExt.deleteByPrimaryKey(shopInfo.getShopInfoId());
    }

    @Deprecated
    public List<ShopInfo> getShopInfoGPSSortedList(final BigDecimal x, final BigDecimal y, int beg, int end){
        List<ShopInfo> shopInfoList = shopInfoMapperExt.selectByExample(null);
        if(beg >= end)
            return new ArrayList<ShopInfo>();
        Collections.sort(shopInfoList, new GPSComparator(x, y));
        end = end < shopInfoList.size()? end:shopInfoList.size();
        return shopInfoList.subList(beg, end);
    }

    public List<ShopInfo> getListByShape(final BigDecimal x, final BigDecimal y, int pageNum){
        return shopInfoMapperExt.selectByShape(x, y, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public List<ShopInfo> getListByShape(int pageNum) {
        return shopInfoMapperExt.selectByShape(DEFAULT_GPS_X, DEFAULT_GPS_Y, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int getTotalPage() {
        int total = shopInfoMapperExt.countByExample(null);
        return PageUtil.getPageNum(total);
    }

    public int getTotalPageByName(String keyword)  {
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        shopInfoExample.or().andShopNameLike(keyword);
        int total = shopInfoMapperExt.countByExample(shopInfoExample);
        return PageUtil.getPageNum(total);
    }

    public ShopInfo getShopById(String id){
        return shopInfoMapperExt.selectByPrimaryKey(id);
    }

    public List<ShopInfo> getShopsByName(String name){
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        shopInfoExample.or().andShopNameLike(StringUtil.likeParam(name));
        shopInfoExample.setOrderByClause("SEQ desc");
        return shopInfoMapperExt.selectByExample(shopInfoExample);
    }

    public List<ShopInfo> getShopsByName(String name, int pageNum){
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        shopInfoExample.or().andShopNameLike(StringUtil.likeParam(name));
        shopInfoExample.setOrderByClause("SEQ DESC" + PageUtil.genPaginationClause(pageNum, PAGE_SIZE));
        return shopInfoMapperExt.selectByExample(shopInfoExample);
    }

    public int updateShopInfo(ShopInfo shopInfo) {
        return 0;
    }

    public ShopActivityDTO shopActivityDTOWrap(ShopInfo shopInfo){
        Integer activityId = activityService.getAvailableActivityIdByShopInfoId(shopInfo.getShopInfoId());
        ShopActivityDTO shopActivityDTO = new ShopActivityDTO();
        try {
            BeanUtils.copyProperties(shopActivityDTO, shopInfo);
            shopActivityDTO.setActivityId(activityId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  shopActivityDTO;
    }

    public List<ShopActivityDTO> shopActivityDTOListWrap(List<ShopInfo> shopInfoList){
        List<ShopActivityDTO> shopActivityDTOList = new ArrayList<ShopActivityDTO>();
        for(ShopInfo shopInfo : shopInfoList){
            shopActivityDTOList.add(shopActivityDTOWrap(shopInfo));
        }
        return  shopActivityDTOList;
    }


}
