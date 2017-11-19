package com.yaoyou.interfaces.controller.item;

import com.yaoyou.interfaces.controller.BaseController;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.Item;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ItemShopDTO;
import com.yaoyou.service.ItemService;
import com.yaoyou.util.ObjectNullCheck;
import com.yaoyou.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/7/20.
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
    @Resource
    ItemService itemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ItemDTO viewItem(@PathVariable int id, Model model){
        ItemDTO itemDTO = itemService.selectItemDTOById(id);
        return ObjectNullCheck.getNonNullObject(ItemDTO.class, itemDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addItem(@RequestBody Item item/*,Model model*/){
        if(ObjectNullCheck.check(item)){
            return newFaildResult("非法操作");
        }
        int result = itemService.addItem(item);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delItem(@RequestBody Item item){
        Item item1 = new Item();
        int result = itemService.deleteItem(item);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result modifyItem(@RequestBody Item item){
        int result = itemService.updateItem(item);
        return newResult(result, "", null);
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<ItemDTO> getAllItem(){
        List<ItemDTO> itemDTOList = itemService.getItemDTOList();
        return itemDTOList;
    }

    @RequestMapping("/list/{pageNum}")
    @ResponseBody
    public List<ItemDTO> getItemByPage(@PathVariable int pageNum){
        List<ItemDTO> itemDTOList = itemService.getItemDTOByPageNum(pageNum);
        return itemDTOList;
    }

    @RequestMapping("/list/total")
    @ResponseBody
    public int getTotalPage(){
        int totalPage = itemService.getTotalPage();
        return totalPage;
    }

    @RequestMapping(value = "/search/shop/{shopInfoId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> searchItemsByShopInfoId(@PathVariable String shopInfoId){
        List<ItemDTO> itemList = itemService.selectItemDTOByShopInfoId(shopInfoId);
        return itemList;
    }
    @RequestMapping(value = "/search/shop/{shopInfoId}/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> searchItemsByShopInfoId(@PathVariable String shopInfoId, @PathVariable int pageNum){
        List<ItemDTO> itemList = itemService.selectItemDTOByShopInfoId(shopInfoId, pageNum);
        return itemList;
    }

    @RequestMapping(value = "/search/shop/{shopInfoId}/totalPage", method = RequestMethod.GET)
    @ResponseBody
    public int totalPageItemsByShopInfoId(@PathVariable String shopInfoId){
        int count = itemService.selectCountByShopInfoId(shopInfoId);
        return PageUtil.getPageNum(count);
    }

    @RequestMapping(value = "/search/medicine/{medicineId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> searchItemsByMedicineId(@PathVariable String medicineId){
        List<ItemDTO> itemList = itemService.selectItemDTOByMedicineId(medicineId);
        return itemList;
    }

    @RequestMapping(value = "/search/medicine/{medicineId}/{pageNum}", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> searchItemsByMedicineId(@PathVariable String medicineId, @PathVariable int pageNum){
        List<ItemDTO> itemList = itemService.selectItemDTOByMedicineId(medicineId, pageNum);
        return itemList;
    }
    @RequestMapping(value = "/search/medicine/{medicineId}/totalPage", method = RequestMethod.GET)
    @ResponseBody
    public int totalPageItemsByMedicineId(@PathVariable String medicineId){
        int count = itemService.selectCountByMedicineId(medicineId);
        return PageUtil.getPageNum(count);
    }
}
