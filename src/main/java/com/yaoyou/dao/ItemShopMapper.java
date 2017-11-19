package com.yaoyou.dao;

import com.yaoyou.model.dataObject.ItemSnap;
import com.yaoyou.model.dto.ItemShopDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by song on 16/8/14.
 */
public interface ItemShopMapper {
//    @Select({
////            "select max(ITEM.STORAGE_COUNT),ITEM.ITEM_ID, ITEM.STATE, PRICE,",
//            "select max(ITEM.STORAGE_COUNT1),",
//            "SHOP_INFO.SHOP_INFO_ID, SHOP_NAME, SHOP_ADDRESS, SHOP_TEL, IS_SEND, IMG_URL, GPS_X, GPS_Y",
//            "from ITEM, SHOP_INFO",
//            "where ITEM.MEDICINE_ID = #{medicineId,jdbcType=VARCHAR} and ITEM.SHOP_INFO_ID = SHOP_INFO.SHOP_INFO_ID and ITEM.STORAGE_COUNT>0 ",
//            "group by SHOP_INFO.SHOP_INFO_ID"
//    })

    @Select({
            "select a.maxId, ITEM.ITEM_ID, ITEM.STORAGE_COUNT,PRICE, SHOP_INFO.SHOP_INFO_ID, SHOP_NAME, SHOP_ADDRESS, SHOP_TEL, IS_SEND, IMG_URL, GPS_X, GPS_Y",
            "from (select max(item_id)as maxId",
                    "from item",
                    "where ITEM.MEDICINE_ID = #{medicineId,jdbcType=VARCHAR} and ITEM.STORAGE_COUNT>0",
                    "group by shop_info_id)as a ,ITEM, SHOP_INFO",
            "where a.maxId = ITEM.ITEM_ID and ITEM.SHOP_INFO_ID = SHOP_INFO.SHOP_INFO_ID"
    })
    List<ItemShopDTO> selectItemShopDTOByMedicineId(String medicineId);

    @Select({
            "select a.maxId, ITEM.ITEM_ID, ITEM.STORAGE_COUNT,PRICE, SHOP_INFO.SHOP_INFO_ID, SHOP_NAME, SHOP_ADDRESS, SHOP_TEL, IS_SEND, IMG_URL, GPS_X, GPS_Y",
            "from (select max(item_id)as maxId",
            "from item",
            "where ITEM.MEDICINE_ID = #{medicineId,jdbcType=VARCHAR} and ITEM.STORAGE_COUNT>0",
            "group by shop_info_id)as a ,ITEM, SHOP_INFO",
            "where a.maxId = ITEM.ITEM_ID and ITEM.SHOP_INFO_ID = SHOP_INFO.SHOP_INFO_ID",
            "LIMIT #{offset},#{limit}"
    })

    List<ItemShopDTO>  selectItemShopDTOByMedicineIdLimit(@Param("medicineId") String medicineId, @Param("offset") int offset, @Param("limit") int limit);
}
