package com.yaoyou.service.schedule;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.yaoyou.dao.*;
import com.yaoyou.model.dataObject.IdRatePair;
import com.yaoyou.model.dataObject.MedicineComment;
import com.yaoyou.service.BaseService;
import com.yaoyou.service.MedicineInfoService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/7/28.
 */
@Component
public class CommentRateUpdater extends BaseService {
    @Resource
    ShopCommentMapper shopCommentMapper;
    @Resource
    MedicineCommentMapper medicineCommentMapper;
    @Resource
    ShopInfoMapperExt shopInfoMapperExt;
    @Resource
    MedicineInfoMapper medicineInfoMapper;
//    @Scheduled(cron = "0 0/1 * * * ?")
    @Scheduled(cron = "5/30 * * * * ?")
    public void updateShopComment(){
        List<IdRatePair> idRatePairList = shopCommentMapper.selectAvgRateList();
//        logger.info("进入task:updateShopComment");
        for(IdRatePair idRatePair : idRatePairList){
//            logger.info(idRatePair.getId() + "        " + idRatePair.getRate());
            shopInfoMapperExt.updateAvgRate(idRatePair);
        }
    }

    @Scheduled(cron = "10/30 * * * * ?")
    public void updateMedicineComment(){
        List<IdRatePair> idRatePairList = medicineCommentMapper.selectAvgRateList();
//        logger.info("进入task:updateMedicineComment");
        for(IdRatePair idRatePair : idRatePairList){
//            logger.info(idRatePair.getId() + "        " + idRatePair.getRate());
            medicineInfoMapper.updateAvgRate(idRatePair);
        }
    }
}
