package com.yaoyou.service;

import com.google.common.collect.Maps;
import com.yaoyou.dao.MedicineCommentMapper;
import com.yaoyou.dao.MedicineInfoMapper;
import com.yaoyou.dao.ShopInfoMapper;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.util.IdGenrator;
import com.yaoyou.util.PageUtil;
import com.yaoyou.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by song on 16/7/20.
 */
@Service
public class MedicineInfoService extends BaseService{
    @Resource
    MedicineInfoMapper medicineInfoMapper;
    @Resource
    MedicineCommentMapper medicineCommentMapper;

    public List<MedicineInfo> getAllMedicine(){
        MedicineInfoExample medicineInfoExample = new MedicineInfoExample();
        medicineInfoExample.setOrderByClause("CREATE_TIME DESC");
        return medicineInfoMapper.selectByExample(medicineInfoExample);
    }

    public List<MedicineInfo> getMedicineByPageNum(int pageNum){
        return medicineInfoMapper.selectByLimit((pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public void addShopInfo(MedicineInfo medicineInfo){
        medicineInfoMapper.insert(medicineInfo);
    }

    public int addMedicine(MedicineInfo medicineInfo) {
        medicineInfo.setMedicineId(IdGenrator.next());
        try {
            return medicineInfoMapper.insert(medicineInfo);
        }catch (Exception e){
            logger.error(e);
            return -1;
        }
    }

    public int deleteMedicine(MedicineInfo medicineInfo) {
        return medicineInfoMapper.deleteByPrimaryKey(medicineInfo.getMedicineId());
    }

    public int getTotalPage() {
        int total = medicineInfoMapper.countByExample(null);
        return PageUtil.getPageNum(total);
    }



    public int getTotalPageByName(String name) {
        MedicineInfoExample medicineInfoExample = new MedicineInfoExample();
        name = StringUtil.likeParam(name);
        medicineInfoExample.or().andBrandNameLike(name);
        medicineInfoExample.or(medicineInfoExample.or().andCadnLike(name));
        int total = medicineInfoMapper.countByExample(medicineInfoExample);
        return PageUtil.getPageNum(total);
    }

    public MedicineInfo getMedicineById(String id) {
        return medicineInfoMapper.selectByPrimaryKey(id);
    }

    public List<MedicineInfo> getMedicineByName(String name){
        MedicineInfoExample medicineInfoExample = new MedicineInfoExample();
        name = StringUtil.likeParam(name);
        medicineInfoExample.or().andBrandNameLike(name);
        medicineInfoExample.or(medicineInfoExample.or().andCadnLike(name));
        return medicineInfoMapper.selectByExample(medicineInfoExample);
    }

    public List<MedicineInfo> getMedicineByName(String name, int pageNum){
        MedicineInfoExample medicineInfoExample = new MedicineInfoExample();
        name = StringUtil.likeParam(name);
        medicineInfoExample.or().andBrandNameLike(name);
        medicineInfoExample.or(medicineInfoExample.or().andCadnLike(name));
        medicineInfoExample.setOrderByClause("AVG_Rate" + PageUtil.genPaginationClause(pageNum, PAGE_SIZE));
        return medicineInfoMapper.selectByExample(medicineInfoExample);
    }

    public List<MedicineComment> getCommentsByMedicineId(String id, int pageNum){
        MedicineCommentExample medicineCommentExample = new MedicineCommentExample();
        return medicineCommentMapper.selectByLimit(id, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int addComment(MedicineComment medicineComment) {
        medicineComment.setCommentId(IdGenrator.next());
        try {
            return medicineCommentMapper.insert(medicineComment);
        }catch (Exception e){
            logger.error(e);
            return -1;
        }
    }

    public int getCommentsTotalPage(String medicineId) {
        MedicineCommentExample medicineCommentExample = new MedicineCommentExample();
        medicineCommentExample.or().andMedicineIdEqualTo(medicineId);
        int total = medicineCommentMapper.countByExample(medicineCommentExample);
        return PageUtil.getPageNum(total);
    }

    public int updateMedicine(MedicineInfo medicineInfo) {
        return 0;
    }

    public int updateComment(MedicineComment medicineComment) {
        return 0;
    }


}
