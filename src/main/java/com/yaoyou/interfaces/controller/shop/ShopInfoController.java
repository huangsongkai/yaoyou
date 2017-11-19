package com.yaoyou.interfaces.controller.shop;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.ShopInfo;
import com.yaoyou.model.dto.ShopActivityDTO;
import com.yaoyou.service.ShopInfoService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by song on 16/7/20.
 */
@Controller
@RequestMapping("/shop")
public class ShopInfoController extends BaseController {
    @Resource
    ShopInfoService shopInfoService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addShopInfo(@RequestBody ShopInfo shopInfo/*,Model model*/){
        logger.info(shopInfo.getShopName());
        if(ObjectNullCheck.check(shopInfo)){
            return newFaildResult("非法操作");
        }
        int result = shopInfoService.addShopInfo(shopInfo);
        return newResult(result,"", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delShopInfo(@RequestBody ShopInfo shopInfo){
        logger.info(shopInfo.getShopInfoId());
        int result = shopInfoService.deleteShopInfo(shopInfo);
        return newResult(result, "", null);
    }


    @RequestMapping("/id/{id}")
    @ResponseBody
    public ShopInfo getShopById(@PathVariable String id){
        return  ObjectNullCheck.getNonNullObject(ShopInfo.class, shopInfoService.getShopById(id));
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyShopInfo(@PathVariable String id,@RequestBody ShopInfo shopInfo/*,Model model*/){
        if(ObjectNullCheck.check(shopInfo)){
            return newFaildResult("非法操作");
        }
        shopInfo.setShopInfoId(id);
        logger.info(shopInfo.getShopName());
        int result = shopInfoService.updateShopInfo(shopInfo);
        return newResult(result,"", null);
    }

    @RequestMapping("/name/{name}")
    @ResponseBody
    public List<ShopInfo> getShopsByName(@PathVariable String name){
        logger.info(name);
        List<ShopInfo> shopInfoList = shopInfoService.getShopsByName(name);
        return shopInfoList;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<ShopActivityDTO> getAllShops(){
        List<ShopInfo> shopInfoList = shopInfoService.getAllShops();
        return shopInfoService.shopActivityDTOListWrap(shopInfoList);
    }

    @RequestMapping("/list/{pageNum}")
    @ResponseBody
    public List<ShopInfo> getShopsByPage(@PathVariable int pageNum){
        List<ShopInfo> shopInfoList = shopInfoService.getShopsByPageNum(pageNum);
        return shopInfoList;
    }

    @RequestMapping("/list/gps/{x}-{y}")
    @ResponseBody
    public List<ShopInfo> getShopsByGps(@PathVariable double x, @PathVariable double y){
        List<ShopInfo> shopInfoList = shopInfoService.getListByShape(new BigDecimal(x), new BigDecimal(y), 1);
        return shopInfoList;
    }

    @RequestMapping("/list/gps/{x}-{y}/page/{pageNum}")
    @ResponseBody
    public List<ShopInfo> getShopsByGps(@PathVariable double x, @PathVariable double y,@PathVariable int pageNum){
        List<ShopInfo> shopInfoList = shopInfoService.getListByShape(new BigDecimal(x), new BigDecimal(y),pageNum);
        return shopInfoList;
    }

    @RequestMapping("/list/gps")
    @ResponseBody
    public List<ShopInfo> getShopsByGpsDefault(){
        List<ShopInfo> shopInfoList = shopInfoService.getListByShape(1);
        return shopInfoList;
    }

    @RequestMapping("/list/gps/page/{pageNum}")
    @ResponseBody
    public List<ShopInfo> getShopsByGpsDefault(@PathVariable int pageNum){
        List<ShopInfo> shopInfoList = shopInfoService.getListByShape(pageNum);
        return shopInfoList;
    }

    @RequestMapping("/list/total")
    @ResponseBody
    public int getTotalPage(){
        int totalPage = shopInfoService.getTotalPage();
        return totalPage;
    }

}
