package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dto.SearchDTO;
import com.yaoyou.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/12.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Resource
    SearchService searchService;

    @RequestMapping(value = "/keyword/{keyword}/page/{pageNum}", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<SearchDTO> search(@PathVariable String keyword, @PathVariable int pageNum) {
        return searchService.searchShopMergeMedicine(keyword, pageNum);
    }
    @RequestMapping(value = "/keyword/{keyword}", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<SearchDTO> search(@PathVariable String keyword) {
        return searchService.searchShopMergeMedicine(keyword, 1);
    }

    @RequestMapping(value = "/keyword/page/{pageNum}", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<SearchDTO> searchDefault(@PathVariable int pageNum) {
        if(pageNum == 0 ) {
            pageNum = 1;
        }
        return searchService.searchShopMergeMedicine(pageNum);
    }
    @RequestMapping(value = "/keyword", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<SearchDTO> searchDefault() {
        return searchService.searchShopMergeMedicine(1);
    }

    @RequestMapping(value = "/keyword/{keyword}/totalPage", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public int totalPage(@PathVariable String  keyword) {
        return searchService.calcTotalPage(keyword);

    }

    @RequestMapping(value = "/keyword/totalPage", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public int totalPage() {
        return searchService.calcTotalPage();

    }

}
