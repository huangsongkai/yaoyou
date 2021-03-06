package com.yaoyou.model.dataObject;

import java.math.BigDecimal;

public class ItemSnap {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    private Integer itemSnapId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEM_SNAP.ITEM_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    private String itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEM_SNAP.PRICE
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEM_SNAP.DESCRIPTION
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEM_SNAP.ITEM_SNAP_ID
     *
     * @return the value of ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public Integer getItemSnapId() {
        return itemSnapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEM_SNAP.ITEM_SNAP_ID
     *
     * @param itemSnapId the value for ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public void setItemSnapId(Integer itemSnapId) {
        this.itemSnapId = itemSnapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEM_SNAP.ITEM_ID
     *
     * @return the value of ITEM_SNAP.ITEM_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEM_SNAP.ITEM_ID
     *
     * @param itemId the value for ITEM_SNAP.ITEM_ID
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEM_SNAP.PRICE
     *
     * @return the value of ITEM_SNAP.PRICE
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEM_SNAP.PRICE
     *
     * @param price the value for ITEM_SNAP.PRICE
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEM_SNAP.DESCRIPTION
     *
     * @return the value of ITEM_SNAP.DESCRIPTION
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEM_SNAP.DESCRIPTION
     *
     * @param description the value for ITEM_SNAP.DESCRIPTION
     *
     * @mbggenerated Sun Aug 14 14:38:21 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}