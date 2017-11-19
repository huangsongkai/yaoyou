package com.yaoyou.interfaces.controller.remind;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.Remind;
import com.yaoyou.service.RemindService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by song on 16/8/17.
 */
@Controller
@RequestMapping("/remind/page")
public class RemindRedirectController extends BaseController {
    @Resource
    RemindService remindService;
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addRemind(){
        return "remind/add";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editRemind(){
        return "remind/edit";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteRemind(){
        return "remind/delete";
    }

    @RequestMapping(value = "/timeTable/add", method = RequestMethod.GET)
    public String addTimeTable(){
        return "remind/timeTable/add";
    }

    @RequestMapping(value = "/timeTable/update", method = RequestMethod.GET)
    public String updateTimeTable(){
        return "remind/timeTable/update";
    }

    @RequestMapping(value = "/timeTable/switch", method = RequestMethod.GET)
    public String redirectToSwitch(){
        return "remind/timeTable/clockSwitch";
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delRemind(@RequestBody Remind remind){
        logger.info(remind.getRemindId());
        int result = remindService.deleteRemind(remind);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyRemind(@RequestBody Remind remind){
        logger.info(remind.getRemindId());
        int result = remindService.updateRemind(remind);
        return newResult(result, "", null);
    }
}
