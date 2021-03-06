package com.yaoyou.dao;

import com.yaoyou.model.dataObject.Order;
import com.yaoyou.model.dataObject.OrderExample;
import java.util.List;

import com.yaoyou.model.dataObject.OrderItem;
import com.yaoyou.model.dto.OrderActivityDTO;
import com.yaoyou.model.dto.OrderItemDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @SelectProvider(type=OrderSqlProvider.class, method="countByExample")
    int countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @DeleteProvider(type=OrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @Delete({
        "delete from t_order",
        "where ORDER_ID = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @Insert({
        "insert into t_order (ORDER_ID, STATE, ",
        "TYPE, USER_ID, TOTAL_PRICE, ",
        "PAY_ID, ADD_ID, DISTRIBUTION_ID, ",
        "CREATE_TIME)",
        "values (#{orderId,jdbcType=INTEGER}, #{state,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, #{totalPrice,jdbcType=DECIMAL}, ",
        "#{payId,jdbcType=INTEGER}, #{addId,jdbcType=INTEGER}, #{distributionId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="orderId")
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ORDER_ID", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOTAL_PRICE", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAY_ID", property="payId", jdbcType=JdbcType.INTEGER),
        @Result(column="ADD_ID", property="addId", jdbcType=JdbcType.INTEGER),
        @Result(column="DISTRIBUTION_ID", property="distributionId", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @Select({
        "select",
        "ORDER_ID, STATE, TYPE, USER_ID, TOTAL_PRICE, PAY_ID, ADD_ID, DISTRIBUTION_ID, ",
        "CREATE_TIME",
        "from t_order",
        "where ORDER_ID = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ORDER_ID", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOTAL_PRICE", property="totalPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAY_ID", property="payId", jdbcType=JdbcType.INTEGER),
        @Result(column="ADD_ID", property="addId", jdbcType=JdbcType.INTEGER),
        @Result(column="DISTRIBUTION_ID", property="distributionId", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Order selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Thu Aug 25 16:14:11 CST 2016
     */
    @Update({
        "update t_order",
        "set STATE = #{state,jdbcType=VARCHAR},",
          "TYPE = #{type,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=VARCHAR},",
          "TOTAL_PRICE = #{totalPrice,jdbcType=DECIMAL},",
          "PAY_ID = #{payId,jdbcType=INTEGER},",
          "ADD_ID = #{addId,jdbcType=INTEGER},",
          "DISTRIBUTION_ID = #{distributionId,jdbcType=INTEGER},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}",
        "where ORDER_ID = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);


    @Select({
            "select item.item_id, item.price as price, item.point as point,activity_item.ACTIVITY_PRICE as ACTIVITY_PRICE, activity_item.ACTIVITY_POINT as ACTIVITY_POINT, activity_id",
            "from item left join activity_item on item.item_id = activity_item.item_id",
            "where item.ITEM_ID = #{itemId,jdbcType=INTEGER}",
    })
    OrderActivityDTO selectOrderItemUnionActivityInfo(int itemId);


    String selectDTOStr = "select o.item_id, o.price, o.point, activity_id, i.medicine_id, cadn, brand_name, s.shop_info_id, shop_name, shop_address, shop_tel";

    String fromDTOStr = "from order_item as o inner join item as i on o.item_id = i.item_id" +
            " inner join medicine_info as m on i.medicine_id = m.medicine_id " +
            "inner join shop_info as s on i.shop_info_id = s.shop_info_id ";

    @Select({
            selectDTOStr,
            fromDTOStr,
            "where o.ORDER_ID = #{orderId,jdbcType=INTEGER}"
    })
    List<OrderItemDTO> selectOrderItemDTO(int orderId);




    @Select({
            "select tor.ORDER_ID AS orderId, tor.state AS state, tor.TYPE AS type,tor.USER_ID AS userId, " +
            "tor.TOTAL_PRICE AS totalPrice,tor.PAY_ID AS payId,tor.ADD_ID AS addId,tor.DISTRIBUTION_ID AS distributionId,tor.CREATE_TIME AS createTime "+
            "from t_order as tor "+
            "inner join order_item AS oim on tor.order_id = oim.order_id "+
            "inner join item AS itm on oim.ITEM_ID = itm.ITEM_ID  "+
            "where itm.SHOP_INFO_ID = #{shopInfoId}"
    })
    List<OrderActivityDTO> selectOrderByShopInfo(String shopInfoId);

    @Select({
            "select tor.ORDER_ID AS orderId, tor.state AS state, tor.TYPE AS type,tor.USER_ID AS userId, " +
            "tor.TOTAL_PRICE AS totalPrice,tor.PAY_ID AS payId,tor.ADD_ID AS addId,tor.DISTRIBUTION_ID AS distributionId,tor.CREATE_TIME AS createTime "+
            "from t_order as tor "+
            "inner join order_item AS oim on tor.order_id = oim.order_id "+
            "inner join item AS itm on oim.ITEM_ID = itm.ITEM_ID  "+
            "where itm.SHOP_INFO_ID = #{shopInfoId}"+
            "LIMIT #{offset},#{limit}"
    })
    List<OrderActivityDTO> selectOrderByShopInfoFroPage( @Param("shopInfoId") String shopInfoId,@Param("offset") int offset, @Param("limit") int limit);
}