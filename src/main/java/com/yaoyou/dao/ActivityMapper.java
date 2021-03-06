package com.yaoyou.dao;

import com.yaoyou.model.dataObject.Activity;
import com.yaoyou.model.dataObject.ActivityExample;
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

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @SelectProvider(type=ActivitySqlProvider.class, method="countByExample")
    int countByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @DeleteProvider(type=ActivitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @Delete({
        "delete from ACTIVITY",
        "where ACTIVITY_ID = #{activityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @Insert({
        "insert into ACTIVITY (ACTIVITY_ID, TITLE, ",
        "TYPE, BODY, IMG_URL, ",
        "BEG_TIME, END_TIME, ",
        "STATE, CREATE_TIME)",
        "values (#{activityId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{body,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, ",
        "#{begTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{state,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @InsertProvider(type=ActivitySqlProvider.class, method="insertSelective")
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @SelectProvider(type=ActivitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ACTIVITY_ID", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="BODY", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="IMG_URL", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="BEG_TIME", property="begTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Activity> selectByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @Select({
        "select",
        "ACTIVITY_ID, TITLE, TYPE, BODY, IMG_URL, BEG_TIME, END_TIME, STATE, CREATE_TIME",
        "from ACTIVITY",
        "where ACTIVITY_ID = #{activityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ACTIVITY_ID", property="activityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="BODY", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="IMG_URL", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="BEG_TIME", property="begTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="STATE", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Activity selectByPrimaryKey(Integer activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @UpdateProvider(type=ActivitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @UpdateProvider(type=ActivitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @UpdateProvider(type=ActivitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ACTIVITY
     *
     * @mbggenerated Fri Aug 26 09:03:10 CST 2016
     */
    @Update({
        "update ACTIVITY",
        "set TITLE = #{title,jdbcType=VARCHAR},",
          "TYPE = #{type,jdbcType=VARCHAR},",
          "BODY = #{body,jdbcType=VARCHAR},",
          "IMG_URL = #{imgUrl,jdbcType=VARCHAR},",
          "BEG_TIME = #{begTime,jdbcType=TIMESTAMP},",
          "END_TIME = #{endTime,jdbcType=TIMESTAMP},",
          "STATE = #{state,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}",
        "where ACTIVITY_ID = #{activityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Activity record);

}