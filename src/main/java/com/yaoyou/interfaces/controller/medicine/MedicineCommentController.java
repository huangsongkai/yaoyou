package com.yaoyou.interfaces.controller.medicine;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.MedicineComment;
import com.yaoyou.service.MedicineInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/3.
 */
@Controller
@RequestMapping("/medicine")
public class MedicineCommentController extends BaseController {
    @Resource
    MedicineInfoService medicineInfoService;

    @RequestMapping("/id/{medicineId}/comment/list/{pageNum}")
    @ResponseBody
    public List<MedicineComment> getCommentsByMedicineId(@PathVariable String medicineId, @PathVariable int pageNum){
        List<MedicineComment> medicineCommentList = medicineInfoService.getCommentsByMedicineId(medicineId, pageNum);
        return medicineCommentList;
    }

    @RequestMapping("/id/{medicineId}/comment/list/total")
    @ResponseBody
    public int getCommentsTotalPage(@PathVariable String medicineId){
        int totalPage = medicineInfoService.getCommentsTotalPage(medicineId);
        return totalPage;
    }

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public Result addComment(@RequestBody MedicineComment medicineComment){
        if(medicineComment == null){
            return newFaildResult("非法操作");
        }
        int result = medicineInfoService.addComment(medicineComment);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/comment",method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyComment(@RequestBody MedicineComment medicineComment){
        if(medicineComment == null){
            return newFaildResult("非法操作");
        }
        int result = medicineInfoService.updateComment(medicineComment);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/comment",method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteComment(@RequestBody MedicineComment medicineComment){
        if(medicineComment == null){
            return newFaildResult("非法操作");
        }
        int result = medicineInfoService.addComment(medicineComment);
        return newResult(result, "", null);
    }


}
