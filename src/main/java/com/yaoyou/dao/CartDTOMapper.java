package com.yaoyou.dao;

import com.yaoyou.model.dataObject.User;
import com.yaoyou.model.dto.CartDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by song on 16/8/6.
 */
public interface CartDTOMapper {

    @Select({
            "select",
            "CART.ITEM_ID, ITEM.PRICE, STORAGE_COUNT, COUNT, ITEM.SHOP_INFO_ID, SHOP_NAME, ITEM.MEDICINE_ID, MEDICINE_INFO.CADN, MEDICINE_INFO.BRAND_NAME, ITEM.CREATE_TIME, MEDICINE_INFO.IMG_URL",
            "from CART, ITEM, MEDICINE_INFO, SHOP_INFO",
            "where USER_ID = #{userId,jdbcType=VARCHAR} and CART.ITEM_ID = ITEM.ITEM_ID and ITEM.MEDICINE_ID = MEDICINE_INFO.MEDICINE_ID and ITEM.SHOP_INFO_ID = SHOP_INFO.SHOP_INFO_ID",
            "order by CART.CREATE_TIME DESC"
    })
    List<CartDTO> selcetByUserId(String userId);

    @Select({
            "select",
            "ITEM.ITEM_ID, STORAGE_COUNT, ITEM.PRICE, STORAGE_COUNT, ITEM.SHOP_INFO_ID, SHOP_NAME, ITEM.MEDICINE_ID, MEDICINE_INFO.CADN, MEDICINE_INFO.BRAND_NAME, MEDICINE_INFO.IMG_URL",
            "from ITEM, MEDICINE_INFO, SHOP_INFO",
            "where item_id = #{itemId,jdbcType=INTEGER} and ITEM.MEDICINE_ID = MEDICINE_INFO.MEDICINE_ID and ITEM.SHOP_INFO_ID = SHOP_INFO.SHOP_INFO_ID",
    })
    CartDTO selectByItemId(int itemId);
}
