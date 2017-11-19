package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.News;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.service.ActivityService;
import com.yaoyou.service.NewsService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by song.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Resource
    NewsService newsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public News view(@PathVariable int id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(News.class, newsService.get(id));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<News> viewList(){
        return newsService.getList(1);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public List<News> viewList(@PathVariable int pageNum, HttpServletRequest request/*,Model model*/){
        return newsService.getList(pageNum);
    }

    @RequestMapping(value = "/list/totalPage", method = RequestMethod.GET)
    @ResponseBody
    public int viewList(HttpServletRequest request/*,Model model*/){
        return newsService.totalPage();
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody News news, HttpServletRequest request/*,Model model*/){
        Result result = newsService.add(news);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody News news, HttpServletRequest request/*,Model model*/){
        int result = newsService.update(news);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@RequestBody News news, HttpServletRequest request/*,Model model*/){
        int result = newsService.delete(news);
        return newResult(result, "", null);
    }


    @RequestMapping(value = "/page/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "news/add";
    }
    @RequestMapping(value = "/page/edit", method = RequestMethod.GET)
    public String redirectEdit(){
        return "news/edit";
    }
    @RequestMapping(value = "/page/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "news/delete";
    }
}
