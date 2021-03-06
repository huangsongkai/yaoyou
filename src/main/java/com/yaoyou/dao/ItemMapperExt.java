package com.yaoyou.dao;

import com.yaoyou.model.dataObject.Item;
import com.yaoyou.model.dto.ItemDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemMapperExt extends ItemMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    @Insert({
            "insert into item (ITEM_ID, PRICE, ",
            "STATE, STORAGE_COUNT, ",
            "DESCRIPTION, SHOP_INFO_ID, ",
            "MEDICINE_ID, CREATE_TIME)",
            "values (#{itemId,jdbcType=INTEGER}, #{price,jdbcType=DECIMAL}, ",
            "#{state,jdbcType=INTEGER}, #{storageCount,jdbcType=INTEGER}, ",
            "#{description,jdbcType=VARCHAR}, #{shopInfoId,jdbcType=VARCHAR}, ",
            "#{medicineId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "itemId")
    int insert(Item record);

    @Select({
            "select *",
            "from item",
            "LIMIT #{offset},#{limit}"
    })
    List<Item> selectByLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Update({
            "update item",
            "set ",
            "STORAGE_COUNT = STORAGE_COUNT - #{count,jdbcType=INTEGER}",
            "where ITEM_ID = #{itemId,jdbcType=INTEGER}"
    })
    int subStorage(@Param("itemId") int itemId, @Param("count") int count);

    @Update({
            "update item",
            "set ",
            "STORAGE_COUNT = STORAGE_COUNT + #{count,jdbcType=INTEGER}",
            "where ITEM_ID = #{itemId,jdbcType=INTEGER}"
    })
    int addStorage(@Param("itemId") int itemId, @Param("count") int count);


    String selectDTOStr = "select i.item_id as item_id, storage_count, activity_price, activity_point, i.price as price, point, " +
            "i.medicine_id as medicine_id, cadn, brand_name, " +
            "i.shop_info_id as shop_info_id, shop_name, shop_address, shop_tel, is_send, a.activity_id";

    String selectDTOStrToo = "select i.item_id as item_id, storage_count, activity_price, activity_point, i.price as price, point, " +
            "i.medicine_id as medicine_id, cadn, brand_name, " +
            "m.cadn AS cadn ,m.brand_name AS barndName, "+
            "i.state as state,i.description as description,i.create_time as createTime," +
            "i.shop_info_id as shop_info_id, shop_name, shop_address, shop_tel, is_send, a.activity_id";

    String fromDTOStr = "from item as i inner join medicine_info as m on i.medicine_id = m.medicine_id " +
            "inner join shop_info as s on i.shop_info_id = s.shop_info_id " +
            "left join activity_item as a on i.item_id = a.item_id ";

    //添加活动有效性判断
    String fromDTOStrExt = "from item as i inner join medicine_info as m on i.medicine_id = m.medicine_id " +
            "inner join shop_info as s on i.shop_info_id = s.shop_info_id " +
            "left join activity_item as a on i.item_id = a.item_id "+
            "left join activity on a.activity_id = activity.activity_id and END_TIME > CURRENT_TIMESTAMP()";
//    select i.item_id as item_id, storage_count, i.price as price, point, activity_price, activity_point,  i.medicine_id as medicine_id, cadn, brand_name, i.shop_info_id as shop_info_id, shop_name, shop_address, shop_tel, is_send, activity_id from item as i inner join medicine_info as m on i.medicine_id = m.medicine_id inner join shop_info as s on i.shop_info_id = s.shop_info_id left join activity_item as a on i.item_id = a.item_id;

    @Select({
            selectDTOStr,
            fromDTOStr
    })
    List<ItemDTO> selectItemDTOList();

    @Select({
            selectDTOStr,
            fromDTOStr,
            "LIMIT #{offset},#{limit}"
    })
    List<ItemDTO> selectItemDTOListByLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Select({
            selectDTOStrToo,
            fromDTOStrExt,
            "where i.shop_info_id = #{shopInfoId,jdbcType=VARCHAR} ",
            "order by a.item_id desc ",
            "LIMIT #{offset},#{limit}"
    })
    List<ItemDTO> selectItemDTOListByShopInfoId(@Param("shopInfoId") String shopInfoId, @Param("offset") int offset, @Param("limit") int limit);

    @Select({
            selectDTOStr,
            fromDTOStrExt,
            "where i.medicine_id = #{medicineId,jdbcType=VARCHAR} ",
            "order by a.item_id desc ",
            "LIMIT #{offset},#{limit}"
    })
    List<ItemDTO> selectItemDTOListByMedicineId(@Param("medicineId") String medicineId, @Param("offset") int offset, @Param("limit") int limit);

    @Select({
            "select count(1) ",
            fromDTOStr,
            "where i.medicine_id = #{medicineId,jdbcType=VARCHAR}",
    })
    int selectCountByMedicineId(String medicineId);

    @Select({
            "select count(1)",
            fromDTOStr,
            "where i.shop_info_id = #{shopInfoId,jdbcType=VARCHAR}",
    })
    int selectCountByShopInfoId(String shopInfoId);

    @Select({
            selectDTOStr,
            fromDTOStr,
            "where i.item_id = #{id,jdbcType=VARCHAR}",
    })
    ItemDTO selectItemDTO(int id);

    @Select({
            selectDTOStrToo,
            fromDTOStrExt,
            "where m.cadn like CONCAT('%','${productName}','%' )",
            "and i.shop_info_id = #{shopInfoId,jdbcType=VARCHAR} ",
            "order by a.item_id desc ",
            "LIMIT #{offset},#{limit}"
            })
    List<ItemDTO> selectItemDTOListByProductName( @Param("shopInfoId") String shopInfoId, @Param("productName") String productName, @Param("offset") int offset, @Param("limit") int limit);

}
