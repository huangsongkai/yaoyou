package com.yaoyou.interfaces.controller.medicine;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.MedicineInfo;
import com.yaoyou.service.MedicineInfoService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/7/20.
 */
@Controller
@RequestMapping("/medicine")
public class MedicineInfoController extends BaseController {
    @Resource
    MedicineInfoService medicineInfoService;

    @RequestMapping("/id/{id}")
    @ResponseBody
    public MedicineInfo getMedicineById(@PathVariable String id){
        MedicineInfo medicineInfo = medicineInfoService.getMedicineById(id);
        return ObjectNullCheck.getNonNullObject(MedicineInfo.class, medicineInfo);
    }



    @RequestMapping("/name/{name}")
    @ResponseBody
    public List<MedicineInfo> getMedicineByName(@PathVariable String name){
        List<MedicineInfo> medicineList = medicineInfoService.getMedicineByName(name);
        return medicineList;
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<MedicineInfo> getAllMedicine(){
        List<MedicineInfo> medicineInfoList = medicineInfoService.getAllMedicine();
        return medicineInfoList;
    }

    @RequestMapping("/list/{pageNum}")
    @ResponseBody
    public List<MedicineInfo> getMedicineByPage(@PathVariable int pageNum){
        List<MedicineInfo> medicineInfoList = medicineInfoService.getMedicineByPageNum(pageNum);
        return medicineInfoList;
    }

    @RequestMapping("/list/total")
    @ResponseBody
    public int getTotalPage(){
        int totalPage = medicineInfoService.getTotalPage();
        return totalPage;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addMedicineInfo(@RequestBody MedicineInfo medicineInfo/*,Model model*/){
        if(ObjectNullCheck.check(medicineInfo)){
            return newFaildResult("非法操作");
        }
        int result = medicineInfoService.addMedicine(medicineInfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delMedicineInfo(@RequestBody MedicineInfo medicineInfo){
        logger.info(medicineInfo.getMedicineId());
        int result = medicineInfoService.deleteMedicine(medicineInfo);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyMedicineInfo(@RequestBody MedicineInfo medicineInfo){
        logger.info(medicineInfo.getMedicineId());
        int result = medicineInfoService.updateMedicine(medicineInfo);
        return newResult(result, "", null);
    }


}
