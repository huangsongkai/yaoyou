package com.yaoyou.service;

import com.yaoyou.dao.ItemMapperExt;
import com.yaoyou.dao.ItemShopMapper;
import com.yaoyou.dao.ItemSnapMapper;
import com.yaoyou.infrastructure.messaging.AddItemSnap;
import com.yaoyou.infrastructure.messaging.AsyncEventEngine;
import com.yaoyou.model.dataObject.Item;
import com.yaoyou.model.dataObject.ItemExample;
import com.yaoyou.model.dataObject.ItemSnap;
import com.yaoyou.model.dto.CartDTO;
import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ItemShopDTO;
import com.yaoyou.util.InvalidStorageException;
import com.yaoyou.util.PageUtil;
import com.yaoyou.util.SafeEqualChecker;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by song on 16/8/3.
 */
@Service
public class ItemService extends BaseService{
    @Resource
    ItemMapperExt itemMapperExt;
    @Resource
    ItemSnapMapper itemSnapMapper;
    @Resource
    ItemShopMapper itemShopMapper;

    public int updateItem(Item item) {
        //item如果价格，描述等信息发生变化，需要生成快照
        Item itemOld = itemMapperExt.selectByPrimaryKey(item.getItemId());
        if(!SafeEqualChecker.isEqualSimpleType(item.getDescription(), itemOld.getDescription()) ||
                !SafeEqualChecker.isEqualSimpleType(item.getPrice(), itemOld.getPrice())){
            AsyncEventEngine.fireEvent(new AddItemSnap(item));
        }
        return itemMapperExt.updateByPrimaryKeySelective(item);
    }

    public int deleteItem(Item item) {
        return itemMapperExt.deleteByPrimaryKey(item.getItemId());
    }

//    插入新单体是 异步产生快照
//           @Options(useGeneratedKeys=true, keyProperty="itemId")


    public int addItem(Item item) {
        int result = itemMapperExt.insert(item);
        AsyncEventEngine.fireEvent(new AddItemSnap(item));
        return result;
    }


    public Item selectById(int id) {
        return itemMapperExt.selectByPrimaryKey(id);
    }

    public Item selectByIdForUpdate(int id) {
        return itemMapperExt.selectByPrimaryKey(id);
    }

    private ItemSnap genSnap(Item item){
        ItemSnap itemSnap = new ItemSnap();
        try {
            BeanUtils.copyProperties(itemSnap, item);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return itemSnap;
    }
    @Deprecated
    public void updateStorage(List<CartDTO> cartDTOList) throws InvalidStorageException {
        for (CartDTO cartDTO : cartDTOList){
            Item i = selectByIdForUpdate(cartDTO.getItemId());
            if(i.getStorageCount() < cartDTO.getStorageCount() )
                throw new InvalidStorageException();
            i.setStorageCount(i.getStorageCount() - cartDTO.getStorageCount());
            updateItem(i);
        }
    }

    public int getLatestItemSnapId(int itemId){
        return itemSnapMapper.selectLatestItemSnapIdByItemId(itemId);
    }

    public List<Item> getAllItems() {
        return itemMapperExt.selectByExample(null);
    }

    public List<Item> getItemByPageNum(int pageNum) {
        return itemMapperExt.selectByLimit((pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    @Override
    public int getTotalPage(){
        ItemExample itemExample = new ItemExample();
        int total = itemMapperExt.countByExample(null);
        return PageUtil.getPageNum(total);
    }

    public List<Item> selectItemByShopInfoId(String shopInfoId) {
        ItemExample itemExample = new ItemExample();
        itemExample.or().andStateEqualTo(1).andShopInfoIdEqualTo(shopInfoId);
        return itemMapperExt.selectByExample(itemExample);
    }

    public List<Item> selectItemByMedicineId(String medicineId) {
        ItemExample itemExample = new ItemExample();
        itemExample.or().andStateEqualTo(1).andMedicineIdEqualTo(medicineId);
        return itemMapperExt.selectByExample(itemExample);
    }
    //TODO 乐观锁么有加

    public int subStorageCount(int itemId, int count) throws InvalidStorageException {
        if (count < 0 )
            throw new IllegalArgumentException();
        if (count > itemMapperExt.selectByPrimaryKey(itemId).getStorageCount())
            throw new InvalidStorageException();
        return itemMapperExt.subStorage(itemId, count);
    }
    public int addStorageCount(int itemId, int count){
        if (count < 0 )
            throw new IllegalArgumentException();
        return itemMapperExt.addStorage(itemId, count);
    }

    public ItemSnap getLatestItemSnap(int itemId) {
        return itemSnapMapper.selectLatestItemByItemId(itemId);
    }

    public List<ItemShopDTO> selectItemShopByMedicineId(String medicineId) {
        List<ItemShopDTO> itemShopDTOList = itemShopMapper.selectItemShopDTOByMedicineId(medicineId);
        return itemShopDTOList;
    }

    public List<ItemShopDTO> selectItemShopDTOByMedicineIdLimit(String medicineId, int pageNum) {
        return itemShopMapper.selectItemShopDTOByMedicineIdLimit(medicineId, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public List<ItemDTO> selectItemDTOByShopInfoId(String shopInfoId) {
        return itemMapperExt.selectItemDTOListByShopInfoId(shopInfoId, 0, PAGE_SIZE);
    }

    public List<ItemDTO> selectItemDTOByShopInfoId(String shopInfoId, int pageNum) {
        return itemMapperExt.selectItemDTOListByShopInfoId(shopInfoId, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public List<ItemDTO> selectItemDTOByMedicineId(String medicineId) {
        return itemMapperExt.selectItemDTOListByMedicineId(medicineId, 0, PAGE_SIZE);
    }

    public List<ItemDTO> selectItemDTOByMedicineId(String medicineId, int pageNum) {
        return itemMapperExt.selectItemDTOListByMedicineId(medicineId, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public int selectCountByMedicineId(String medicineId) {
        return itemMapperExt.selectCountByMedicineId(medicineId);
    }

    public int selectCountByShopInfoId(String shopInfoId) {
        return itemMapperExt.selectCountByShopInfoId(shopInfoId);
    }

    public List<ItemDTO> getItemDTOList() {
        return itemMapperExt.selectItemDTOList();
    }

    public List<ItemDTO> getItemDTOByPageNum(int pageNum) {
        return itemMapperExt.selectItemDTOListByLimit((pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }

    public ItemDTO selectItemDTOById(int id) {
        return itemMapperExt.selectItemDTO(id);
    }

    public List<ItemDTO> selectProductNameForPage(String productName, int pageNum, String shopInfoId) {
        return itemMapperExt.selectItemDTOListByProductName(shopInfoId,productName, (pageNum - 1) * PAGE_SIZE, PAGE_SIZE);
    }
}

