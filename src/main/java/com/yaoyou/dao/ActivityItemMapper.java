package com.yaoyou.dao;

import com.yaoyou.model.dataObject.ActivityItem;
import com.yaoyou.model.dataObject.ActivityItemExample;
import java.util.List;

import com.yaoyou.model.dto.ItemDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ActivityItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @SelectProvider(type=ActivityItemSqlProvider.class, method="countByExample")
    int countByExample(ActivityItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @DeleteProvider(type=ActivityItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(ActivityItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @Insert({
        "insert into ACTIVITY_ITEM (ACTIVITY_ID, ITEM_ID, ",
        "ACTIVITY_PRICE, ACTIVITY_POINT, ",
        "DESCRIPTION, CREATE_TIME)",
        "values (#{activityId,jdbcType=INTEGER}, #{itemId,jdbcType=INTEGER}, ",
        "#{activityPrice,jdbcType=DECIMAL}, #{activityPoint,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(ActivityItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @InsertProvider(type=ActivityItemSqlProvider.class, method="insertSelective")
    int insertSelective(ActivityItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @SelectProvider(type=ActivityItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ACTIVITY_ID", property="activityId", jdbcType=JdbcType.INTEGER),
        @Result(column="ITEM_ID", property="itemId", jdbcType=JdbcType.INTEGER),
        @Result(column="ACTIVITY_PRICE", property="activityPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ACTIVITY_POINT", property="activityPoint", jdbcType=JdbcType.INTEGER),
        @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActivityItem> selectByExample(ActivityItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @UpdateProvider(type=ActivityItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ActivityItem record, @Param("example") ActivityItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY_ITEM
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @UpdateProvider(type=ActivityItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ActivityItem record, @Param("example") ActivityItemExample example);

    String selectDTOStr = "select i.item_id as item_id, storage_count, activity_price, activity_point, i.price as price, point, " +
            "i.medicine_id as medicine_id, cadn, brand_name, " +
            "i.shop_info_id as shop_info_id, shop_name, shop_address, shop_tel, is_send, activity_id";

    String fromDTOStr = "from item as i inner join medicine_info as m on i.medicine_id = m.medicine_id " +
            "inner join shop_info as s on i.shop_info_id = s.shop_info_id " +
            "left join activity_item as a on i.item_id = a.item_id ";

    @Select ({
            selectDTOStr,
            fromDTOStr,
            "where activity_id = #{id,jdbcType=INTEGER} "
    })
    List<ItemDTO> selectItemDTO(int id);
}