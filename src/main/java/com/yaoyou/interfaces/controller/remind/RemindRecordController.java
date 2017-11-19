package com.yaoyou.interfaces.controller.remind;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.model.dataObject.MedicineRemindRecord;
import com.yaoyou.service.RemindService;
import com.yaoyou.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/19.
 */
@Controller
@RequestMapping("/remind/record")
public class RemindRecordController extends BaseController {
    @Resource
    RemindService remindService;

    @RequestMapping("/{userId}/{time}")
    @ResponseBody
    public RecordResult getUserRecordListByMonth(@PathVariable String userId, @PathVariable String time){
        List<MedicineRemindRecord> medicineRemindRecordList = remindService.getMedicineRemindRecordList(userId, time);
        RecordResult recordResult = new RecordResult();
        recordResult.setTime(time);
        String str = "";
        for(MedicineRemindRecord medicineRemindRecord : medicineRemindRecordList){
            str += medicineRemindRecord.getMedicineName() +",";
        }
        str = str.substring(0, str.length()-1);
        recordResult.setMedicineListStr(str);
        return recordResult;
    }

    @RequestMapping("/list/{userId}/{pageNum}")
    @ResponseBody
    public List<RecordResult> getUserRecordList(@PathVariable String userId, @PathVariable int pageNum){
        List<MedicineRemindRecord> windowList = remindService.getDistinctUserTimeListByPageNum(userId, pageNum);
        if(windowList.size() == 0)
            return new ArrayList<RecordResult>();
        String timeBeg = windowList.get(windowList.size()-1).getTime();
        String timeEnd = windowList.get(0).getTime();

        List<MedicineRemindRecord> medicineRemindRecordList = remindService.getMedicineRemindRecordList(userId, timeBeg, timeEnd);
        List<RecordResult> recordResultList = new ArrayList<RecordResult>();
        int size;
        RecordResult recordResult;
        for(MedicineRemindRecord medicineRemindRecord : medicineRemindRecordList){
            size = recordResultList.size();
            if(recordResultList.size() == 0 || !recordResultList.get(size - 1).getTime().equals(medicineRemindRecord.getTime())){
                recordResult = new RecordResult();
                recordResult.setTime(medicineRemindRecord.getTime());
                recordResult.setMedicineListStr(medicineRemindRecord.getMedicineName());
                recordResultList.add(recordResult);
            }else{
                recordResult = recordResultList.get(size - 1);
                recordResult.setMedicineListStr(recordResult.getMedicineListStr()+","+medicineRemindRecord.getMedicineName());
            }
        }
        return recordResultList;
    }

    @RequestMapping("/list/{userId}/totalPage")
    @ResponseBody
    public int getTotalPage(@PathVariable String userId){
        return remindService.getRecordTotalPage(userId);
    }

    class RecordResult{
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMedicineListStr() {
            return medicineListStr;
        }

        public void setMedicineListStr(String medicineListStr) {
            this.medicineListStr = medicineListStr;
        }

        String time;
        String medicineListStr;
    }
}
