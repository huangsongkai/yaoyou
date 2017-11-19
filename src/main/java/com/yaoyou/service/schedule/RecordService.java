package com.yaoyou.service.schedule;

import com.yaoyou.dao.*;
import com.yaoyou.model.dataObject.IdRatePair;
import com.yaoyou.model.dataObject.MedicineRemindRecord;
import com.yaoyou.model.dataObject.MedicineRemindRecordExample;
import com.yaoyou.model.dataObject.Remind;
import com.yaoyou.service.BaseService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by song on 16/8/19.
 */
@Component
public class RecordService extends BaseService {
    @Resource
    MedicineRemindRecordMapper medicineRemindRecordMapper;

    @Resource
    RemindMapper remindMapper;

    //每天23点执行 服药记录插入
//    @Scheduled(cron = "0 0 23 * * ?")
    @Scheduled(cron = "0 1 0 * * ?")
    public void insertRecordByDay() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String day = sdf.format(d);
        List<Remind> remindList = remindMapper.selectByExample(null);
        MedicineRemindRecord medicineRemindRecord = new MedicineRemindRecord();
        for (Remind remind : remindList) {
            medicineRemindRecord.setUserId(remind.getUserId());
            medicineRemindRecord.setMedicineName(remind.getMedicineName());
            medicineRemindRecord.setTime(day);
            MedicineRemindRecordExample medicineRemindRecordExample = new MedicineRemindRecordExample();
            medicineRemindRecordExample.or().andUserIdEqualTo(medicineRemindRecord.getUserId()).andTimeEqualTo(medicineRemindRecord.getTime()).andMedicineNameEqualTo(medicineRemindRecord.getMedicineName());
            if( 0 == medicineRemindRecordMapper.countByExample(medicineRemindRecordExample))
                medicineRemindRecordMapper.insert(medicineRemindRecord);
        }
    }

    public static void main(String[] args) throws ParseException {
        Calendar now = Calendar.getInstance();
        System.out.println("年: " + now.get(Calendar.YEAR));
        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("分: " + now.get(Calendar.MINUTE));
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dateNowStr = sdf.format(d);
        System.out.println("格式化后的日期：" + dateNowStr);
    }
}
