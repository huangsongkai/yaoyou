package com.yaoyou.service;

import com.yaoyou.dao.MedicineRemindRecordMapper;
import com.yaoyou.dao.RemindMapper;
import com.yaoyou.dao.TimeTableMapper;
import com.yaoyou.model.dataObject.*;
import com.yaoyou.model.dto.RemindDTO;
import com.yaoyou.util.DataTransfer;
import com.yaoyou.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/17.
 */
@Service
public class RemindService extends BaseService {
    @Resource
    RemindMapper remindMapper;
    @Resource
    TimeTableMapper timeTableMapper;
    @Resource
    MedicineRemindRecordMapper medicineRemindRecordMapper;
    @Resource
    UserService userService;

    int PAGE_SIZE = 6;

    public int addRemind(Remind remind) {
        remindMapper.insert(remind);
        return remind.getRemindId();
    }

    public int deleteRemind(Remind remind) {
        int result = remindMapper.deleteByPrimaryKey(remind.getRemindId());
        TimeTableExample timeTableExample = new TimeTableExample();
        timeTableExample.or().andRemindIdEqualTo(remind.getRemindId());
        timeTableMapper.deleteByExample(timeTableExample);
        return result;
    }

    public int updateRemind(Remind remind) {
        return remindMapper.updateByPrimaryKeySelective(remind);
    }

    public boolean isCountOverFlow(Integer remindId) {
        return false;
    }

    public int addTimeTable(TimeTable timeTable) {
        timeTableMapper.insert(timeTable);
        return timeTable.getId();
    }

    public int updateTimeTable(TimeTable timeTable) {
        TimeTableExample timeTableExample = new TimeTableExample();
        timeTableExample.or().andIdEqualTo(timeTable.getId());
        return timeTableMapper.updateByExampleSelective(timeTable, timeTableExample);
    }

    public RemindDTO getRemindById(int remindId) {
        Remind remind = remindMapper.selectByPrimaryKey(remindId);
        RemindDTO remindDTO = DataTransfer.toDestClass(remind, RemindDTO.class);
        TimeTableExample timeTableExample = new TimeTableExample();
        timeTableExample.or().andRemindIdEqualTo(remindId);
        timeTableExample.setOrderByClause("HH, MM");
        remindDTO.setTimeTableList(timeTableMapper.selectByExample(timeTableExample));
        User user = userService.getUserById(remindDTO.getCreator());
        remindDTO.setUserName(user.getUserName());
        remindDTO.setMobile(user.getMobile());
        remindDTO.setUserImg(user.getImg());
        return remindDTO;
    }

    public List<RemindDTO> getRemindListByFromUserId(String userId) {
        RemindExample remindExample = new RemindExample();
        remindExample.or().andCreatorEqualTo(userId).andUserIdNotEqualTo(userId);
        return genRemindDTOList(remindExample);
    }

    public List<RemindDTO> getRemindListByToUserId(String userId) {
        RemindExample remindExample = new RemindExample();
        remindExample.or().andUserIdEqualTo(userId);
        return genRemindDTOList(remindExample);
    }

    private List<RemindDTO> genRemindDTOList(RemindExample remindExample){
        List<Remind> remindList = remindMapper.selectByExample(remindExample);
        List<RemindDTO> remindDTOList = new ArrayList<RemindDTO>();
        for(Remind remind : remindList){
            remindDTOList.add(getRemindById(remind.getRemindId()));
        }
        return remindDTOList;
    }

    public RemindDTO addRemindDTO(RemindDTO remindDTO) {
        try {
            Remind remind = DataTransfer.toDestClass(remindDTO, Remind.class);
            int remindId = addRemind(remind);
            remindDTO.setRemindId(remindId);
            List<TimeTable> timeTableList = remindDTO.getTimeTableList();
            for(TimeTable timeTable : timeTableList){
                timeTable.setRemindId(remindId);
                addTimeTable(timeTable);
            }
            return remindDTO;
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }

    public int updateRemindDTO(RemindDTO remindDTO) {
        try {
            Remind remind = DataTransfer.toDestClass(remindDTO, Remind.class);
            updateRemind(remind);
            List<TimeTable> timeTableList = remindDTO.getTimeTableList();
            for(TimeTable timeTable : timeTableList){
                updateTimeTable(timeTable);
            }
        }catch (Exception e){
            logger.error(e);
            return 0;
        }
        return 1;
    }

    public List<MedicineRemindRecord> getMedicineRemindRecordList(String userId, String time){
        MedicineRemindRecordExample medicineRemindRecordExample = new MedicineRemindRecordExample();
        medicineRemindRecordExample.or().andUserIdEqualTo(userId).andTimeEqualTo(time);
        return medicineRemindRecordMapper.selectByExample(medicineRemindRecordExample);
    }
    public List<MedicineRemindRecord> getMedicineRemindRecordList(String userId, int pageNum){
        MedicineRemindRecordExample medicineRemindRecordExample = new MedicineRemindRecordExample();
        medicineRemindRecordExample.or().andUserIdEqualTo(userId);
        medicineRemindRecordExample.setOrderByClause("TIME DESC" + PageUtil.genPaginationClause(pageNum, 12));
        return medicineRemindRecordMapper.selectByExample(medicineRemindRecordExample);
    }

    public List<MedicineRemindRecord> getMedicineRemindRecordList(String userId, String timeBeg, String timeEnd) {
        MedicineRemindRecordExample medicineRemindRecordExample = new MedicineRemindRecordExample();
        medicineRemindRecordExample.or().andUserIdEqualTo(userId).andTimeBetween(timeBeg, timeEnd);
        medicineRemindRecordExample.setOrderByClause("TIME DESC");
        return medicineRemindRecordMapper.selectByExample(medicineRemindRecordExample);
    }

    public List<MedicineRemindRecord> getDistinctUserTimeListByPageNum(String userId, int pageNum) {
        return medicineRemindRecordMapper.selectDistinctUserTimeListByLimit(userId, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int getRecordTotalPage(String userId) {
        List<MedicineRemindRecord> medicineRemindRecordList = medicineRemindRecordMapper.selectDistinctUserTimeList(userId);
        if(medicineRemindRecordList == null)
            return 0;
        return PageUtil.getPageNum(medicineRemindRecordList.size(), PAGE_SIZE);
    }
}
