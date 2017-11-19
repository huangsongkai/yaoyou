package com.yaoyou.model.dataObject;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Item {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.ITEM_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.PRICE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.STATE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.STORAGE_COUNT
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private Integer storageCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.DESCRIPTION
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.SHOP_INFO_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private String shopInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.MEDICINE_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private String medicineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.CREATE_TIME
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.ITEM_ID
     *
     * @return the value of item.ITEM_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.ITEM_ID
     *
     * @param itemId the value for item.ITEM_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.PRICE
     *
     * @return the value of item.PRICE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.PRICE
     *
     * @param price the value for item.PRICE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.STATE
     *
     * @return the value of item.STATE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.STATE
     *
     * @param state the value for item.STATE
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.STORAGE_COUNT
     *
     * @return the value of item.STORAGE_COUNT
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public Integer getStorageCount() {
        return storageCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.STORAGE_COUNT
     *
     * @param storageCount the value for item.STORAGE_COUNT
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setStorageCount(Integer storageCount) {
        this.storageCount = storageCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.DESCRIPTION
     *
     * @return the value of item.DESCRIPTION
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.DESCRIPTION
     *
     * @param description the value for item.DESCRIPTION
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.SHOP_INFO_ID
     *
     * @return the value of item.SHOP_INFO_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public String getShopInfoId() {
        return shopInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.SHOP_INFO_ID
     *
     * @param shopInfoId the value for item.SHOP_INFO_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setShopInfoId(String shopInfoId) {
        this.shopInfoId = shopInfoId == null ? null : shopInfoId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.MEDICINE_ID
     *
     * @return the value of item.MEDICINE_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public String getMedicineId() {
        return medicineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.MEDICINE_ID
     *
     * @param medicineId the value for item.MEDICINE_ID
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.CREATE_TIME
     *
     * @return the value of item.CREATE_TIME
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.CREATE_TIME
     *
     * @param createTime the value for item.CREATE_TIME
     *
     * @mbggenerated Thu Aug 04 10:58:03 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}