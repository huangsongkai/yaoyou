package com.yaoyou.dao;

import com.yaoyou.model.dataObject.ItemSnap;
import com.yaoyou.model.dataObject.ItemSnapExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ItemSnapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @SelectProvider(type=ItemSnapSqlProvider.class, method="countByExample")
    int countByExample(ItemSnapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @DeleteProvider(type=ItemSnapSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemSnapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @Delete({
            "delete from ITEM_SNAP",
            "where ITEM_SNAP_ID = #{itemSnapId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer itemSnapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @Insert({
            "insert into ITEM_SNAP (ITEM_SNAP_ID, ITEM_ID, ",
            "PRICE, DESCRIPTION)",
            "values (#{itemSnapId,jdbcType=INTEGER}, #{itemId,jdbcType=VARCHAR}, ",
            "#{price,jdbcType=DECIMAL}, #{description,jdbcType=VARCHAR})"
    })
    int insert(ItemSnap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @InsertProvider(type=ItemSnapSqlProvider.class, method="insertSelective")
    int insertSelective(ItemSnap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @SelectProvider(type=ItemSnapSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="ITEM_SNAP_ID", property="itemSnapId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="ITEM_ID", property="itemId", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<ItemSnap> selectByExample(ItemSnapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @Select({
            "select",
            "ITEM_SNAP_ID, ITEM_ID, PRICE, DESCRIPTION",
            "from ITEM_SNAP",
            "where ITEM_SNAP_ID = #{itemSnapId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="ITEM_SNAP_ID", property="itemSnapId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="ITEM_ID", property="itemId", jdbcType=JdbcType.VARCHAR),
            @Result(column="PRICE", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="DESCRIPTION", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ItemSnap selectByPrimaryKey(Integer itemSnapId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @UpdateProvider(type=ItemSnapSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ItemSnap record, @Param("example") ItemSnapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @UpdateProvider(type=ItemSnapSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ItemSnap record, @Param("example") ItemSnapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @UpdateProvider(type=ItemSnapSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ItemSnap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEM_SNAP
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    @Update({
            "update ITEM_SNAP",
            "set ITEM_ID = #{itemId,jdbcType=VARCHAR},",
            "PRICE = #{price,jdbcType=DECIMAL},",
            "DESCRIPTION = #{description,jdbcType=VARCHAR}",
            "where ITEM_SNAP_ID = #{itemSnapId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ItemSnap record);

    @Select({
            "select ITEM_SNAP_ID",
            "from ITEM_SNAP",
            "where ITEM_ID = #{itemId,jdbcType=INTEGER}",
            "order by ITEM_SNAP_ID DESC",
            "limit 1"
    })
    int selectLatestItemSnapIdByItemId(int itemId);

    @Select({
            "select *",
            "from ITEM_SNAP",
            "where ITEM_ID = #{itemId,jdbcType=INTEGER}",
            "order by ITEM_SNAP_ID DESC",
            "limit 1"
    })
    ItemSnap selectLatestItemByItemId(int itemId);
}