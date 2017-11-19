package com.yaoyou.interfaces.controller.remind;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.Remind;
import com.yaoyou.model.dataObject.TimeTable;
import com.yaoyou.model.dto.RemindDTO;
import com.yaoyou.service.RemindService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/17.
 */
@Controller
@RequestMapping("/remind")
public class RemindController extends BaseController {
    @Resource
    RemindService remindService;
    @RequestMapping(value = "/{remindId}", method = RequestMethod.GET)
    @ResponseBody
    public RemindDTO getRemind(@PathVariable int remindId){
        return ObjectNullCheck.getNonNullObject(RemindDTO.class,ObjectNullCheck.getNonNullObject(RemindDTO.class, remindService.getRemindById(remindId)));
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addRemind(@RequestBody RemindDTO remindDTO/*,Model model*/){
        RemindDTO result = remindService.addRemindDTO(remindDTO);
        if(result == null)
            return newFaildResult("添加失败");
        return newSuccessResult("添加成功", result);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delRemind(@RequestBody Remind remind){
        logger.info(remind.getRemindId());
        int result = remindService.deleteRemind(remind);
        if(result < 1)
            return newFaildResult("删除失败，没找到资源");
        return newResult(result, "删除成功", null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyRemind(@RequestBody RemindDTO remindDTO){
        int result = remindService.updateRemindDTO(remindDTO);
        return newResult(result, "修改成功", null);
    }

    @RequestMapping(value = "/timeTable", method = RequestMethod.GET)
    @ResponseBody
    public String addTimeTable(/*,Model model*/){
        System.out.println("aaa");
        return "/";
    }

    @RequestMapping(value = "/timeTable", method = RequestMethod.POST)
    @ResponseBody
    public Result addTimeTable(@RequestBody TimeTable timeTable/*,Model model*/){
        int result = remindService.addTimeTable(timeTable);
        return newSuccessResult(result+"", null);
    }

    @RequestMapping(value = "/timeTable", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyTimeTable(@RequestBody TimeTable timeTable/*,Model model*/){
        int result = remindService.updateTimeTable(timeTable);
        return newSuccessResult(result+"", null);
    }


    @RequestMapping(value = "/list/from/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<RemindDTO> getRemindFromList(@PathVariable String userId){
        return remindService.getRemindListByFromUserId(userId);
    }

    @RequestMapping(value = "/list/to/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<RemindDTO> getRemindToList(@PathVariable String userId){
        return remindService.getRemindListByToUserId(userId);
    }

}
