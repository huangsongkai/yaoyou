package com.yaoyou.dao;

import com.yaoyou.model.dataObject.IdRatePair;
import com.yaoyou.model.dataObject.ShopInfo;
import com.yaoyou.model.dataObject.ShopInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.util.List;

public interface ShopInfoMapperExt extends ShopInfoMapper {

    @Select({
            "select *",
            "from SHOP_INFO",
            "order by SEQ DESC, CREATE_TIME DESC ",
            "LIMIT #{offset},#{limit}"
    })
    List<ShopInfo> selectByLimit(@Param("offset") int offset, @Param("limit") int limit);

    @Update({
            "update SHOP_INFO",
            "set AVG_RATE = #{rate,jdbcType=DECIMAL}",
            "where SHOP_INFO_ID = #{id,jdbcType=VARCHAR}"
    })
    int updateAvgRate(IdRatePair idRatePair);

    @Update({
            "update SHOP_INFO",
            "set SHOP_NAME = #{shopName,jdbcType=VARCHAR},",
            "SEQ = #{seq,jdbcType=INTEGER},",
            "SHOP_ADDRESS = #{shopAddress,jdbcType=VARCHAR},",
            "SHOP_TEL = #{shopTel,jdbcType=VARCHAR},",
            "IS_SEND = #{isSend,jdbcType=VARCHAR},",
            "IMG_URL = #{imgUrl,jdbcType=VARCHAR},",
            "GPS_X = #{gpsX,jdbcType=DECIMAL},",
            "GPS_Y = #{gpsY,jdbcType=DECIMAL},",
            "STATE = #{state,jdbcType=VARCHAR},",
            "CREATE_USER_NAME = #{createUserName,jdbcType=VARCHAR},",
            "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
            "CREATE_USER_ID = #{createUserId,jdbcType=VARCHAR},",
            "AVG_RATE = #{avgRate,jdbcType=DECIMAL}",
            "SHAPE = POINT(#{gpsX,jdbcType=DECIMAL}, #{gpsY,jdbcType=DECIMAL})",
            "where SHOP_INFO_ID = #{shopInfoId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ShopInfo record);

    @Insert({
            "insert into SHOP_INFO (SHOP_INFO_ID, SHOP_NAME, ",
            "SEQ, SHOP_ADDRESS, ",
            "SHOP_TEL, IS_SEND, ",
            "IMG_URL, GPS_X, GPS_Y, ",
            "STATE, CREATE_USER_NAME, ",
            "CREATE_TIME, CREATE_USER_ID, ",
            "AVG_RATE,",
            "SHAPE)",
            "values (#{shopInfoId,jdbcType=VARCHAR}, #{shopName,jdbcType=VARCHAR}, ",
            "#{seq,jdbcType=INTEGER}, #{shopAddress,jdbcType=VARCHAR}, ",
            "#{shopTel,jdbcType=VARCHAR}, #{isSend,jdbcType=VARCHAR}, ",
            "#{imgUrl,jdbcType=VARCHAR}, #{gpsX,jdbcType=DECIMAL}, #{gpsY,jdbcType=DECIMAL}, ",
            "#{state,jdbcType=VARCHAR}, #{createUserName,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
            "#{avgRate,jdbcType=DECIMAL}, ",
            "POINT(#{gpsX,jdbcType=DECIMAL}, #{gpsY,jdbcType=DECIMAL}))"
    })
    int insert(ShopInfo record);

    @Select({
            "select *,st_distance_sphere(shape, point(#{gps_x},#{gps_y})) as distance",
            "from SHOP_INFO",
            "order by distance ",
            "LIMIT #{offset},#{limit}"
    })
    List<ShopInfo> selectByShape(@Param("gps_x") BigDecimal gps_x, @Param("gps_y") BigDecimal gps_y, @Param("offset") int offset, @Param("limit") int limit);
}