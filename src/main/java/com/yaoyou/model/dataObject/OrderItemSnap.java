package com.yaoyou.model.dataObject;

public class OrderItemSnap {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM_SNAP.ORDER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    private Integer orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    private Integer itemSnapId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ORDER_ITEM_SNAP.USER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    private String userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM_SNAP.ORDER_ID
     *
     * @return the value of ORDER_ITEM_SNAP.ORDER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM_SNAP.ORDER_ID
     *
     * @param orderId the value for ORDER_ITEM_SNAP.ORDER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM_SNAP.ITEM_SNAP_ID
     *
     * @return the value of ORDER_ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public Integer getItemSnapId() {
        return itemSnapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM_SNAP.ITEM_SNAP_ID
     *
     * @param itemSnapId the value for ORDER_ITEM_SNAP.ITEM_SNAP_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public void setItemSnapId(Integer itemSnapId) {
        this.itemSnapId = itemSnapId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ORDER_ITEM_SNAP.USER_ID
     *
     * @return the value of ORDER_ITEM_SNAP.USER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ORDER_ITEM_SNAP.USER_ID
     *
     * @param userId the value for ORDER_ITEM_SNAP.USER_ID
     *
     * @mbggenerated Sun Aug 07 20:59:01 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}