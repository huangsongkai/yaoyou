package com.yaoyou.model.dataObject;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.ORDER_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.ITEM_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.COUNT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Integer count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.PRICE
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.POINT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Integer point;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.ACTIVITY_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Integer activityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM.CREATE_TIME
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.ORDER_ID
     *
     * @return the value of ORDER_ITEM.ORDER_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.ORDER_ID
     *
     * @param orderId the value for ORDER_ITEM.ORDER_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.ITEM_ID
     *
     * @return the value of ORDER_ITEM.ITEM_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.ITEM_ID
     *
     * @param itemId the value for ORDER_ITEM.ITEM_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.COUNT
     *
     * @return the value of ORDER_ITEM.COUNT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Integer getCount() {
        return count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.COUNT
     *
     * @param count the value for ORDER_ITEM.COUNT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.PRICE
     *
     * @return the value of ORDER_ITEM.PRICE
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.PRICE
     *
     * @param price the value for ORDER_ITEM.PRICE
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.POINT
     *
     * @return the value of ORDER_ITEM.POINT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.POINT
     *
     * @param point the value for ORDER_ITEM.POINT
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.ACTIVITY_ID
     *
     * @return the value of ORDER_ITEM.ACTIVITY_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.ACTIVITY_ID
     *
     * @param activityId the value for ORDER_ITEM.ACTIVITY_ID
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM.CREATE_TIME
     *
     * @return the value of ORDER_ITEM.CREATE_TIME
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM.CREATE_TIME
     *
     * @param createTime the value for ORDER_ITEM.CREATE_TIME
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}