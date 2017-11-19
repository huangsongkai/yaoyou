package com.yaoyou.dao;

import com.yaoyou.model.dataObject.Address;
import com.yaoyou.model.dataObject.AddressExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface AddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @SelectProvider(type=AddressSqlProvider.class, method="countByExample")
    int countByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @DeleteProvider(type=AddressSqlProvider.class, method="deleteByExample")
    int deleteByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @Delete({
        "delete from ADDRESS",
        "where ADDRESS_ID = #{addressId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @Insert({
        "insert into ADDRESS (ADDRESS_ID, USER_ID, ",
        "NAME, PROVINCE, ",
        "CITY, COUNTY, DETAIL, ",
        "MOBILE, EMAIL, IS_DEFAULT, ",
        "TAG)",
        "values (#{addressId,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{county,jdbcType=VARCHAR}, #{detail,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{isDefault,jdbcType=VARCHAR}, ",
        "#{tag,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true, keyProperty="addressId")
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @InsertProvider(type=AddressSqlProvider.class, method="insertSelective")
    int insertSelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @SelectProvider(type=AddressSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ADDRESS_ID", property="addressId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROVINCE", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="CITY", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="COUNTY", property="county", jdbcType=JdbcType.VARCHAR),
        @Result(column="DETAIL", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_DEFAULT", property="isDefault", jdbcType=JdbcType.VARCHAR),
        @Result(column="TAG", property="tag", jdbcType=JdbcType.VARCHAR)
    })
    List<Address> selectByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @Select({
        "select",
        "ADDRESS_ID, USER_ID, NAME, PROVINCE, CITY, COUNTY, DETAIL, MOBILE, EMAIL, IS_DEFAULT, ",
        "TAG",
        "from ADDRESS",
        "where ADDRESS_ID = #{addressId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ADDRESS_ID", property="addressId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROVINCE", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="CITY", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="COUNTY", property="county", jdbcType=JdbcType.VARCHAR),
        @Result(column="DETAIL", property="detail", jdbcType=JdbcType.VARCHAR),
        @Result(column="MOBILE", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="EMAIL", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_DEFAULT", property="isDefault", jdbcType=JdbcType.VARCHAR),
        @Result(column="TAG", property="tag", jdbcType=JdbcType.VARCHAR)
    })
    Address selectByPrimaryKey(Integer addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @UpdateProvider(type=AddressSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @UpdateProvider(type=AddressSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @UpdateProvider(type=AddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ADDRESS
     *
     * @mbggenerated Tue Aug 23 10:36:51 CST 2016
     */
    @Update({
        "update ADDRESS",
        "set USER_ID = #{userId,jdbcType=VARCHAR},",
          "NAME = #{name,jdbcType=VARCHAR},",
          "PROVINCE = #{province,jdbcType=VARCHAR},",
          "CITY = #{city,jdbcType=VARCHAR},",
          "COUNTY = #{county,jdbcType=VARCHAR},",
          "DETAIL = #{detail,jdbcType=VARCHAR},",
          "MOBILE = #{mobile,jdbcType=VARCHAR},",
          "EMAIL = #{email,jdbcType=VARCHAR},",
          "IS_DEFAULT = #{isDefault,jdbcType=VARCHAR},",
          "TAG = #{tag,jdbcType=VARCHAR}",
        "where ADDRESS_ID = #{addressId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address record);
}