package com.yaoyou.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by song on 16/8/26.
 */
public class OrderActivityDTO {

    private Integer orderId;
    private Integer cadn;

    public Integer getBrandName() {
        return brandName;
    }

    public void setBrandName(Integer brandName) {
        this.brandName = brandName;
    }

    public Integer getCadn() {
        return cadn;
    }

    public void setCadn(Integer cadn) {
        this.cadn = cadn;
    }

    private Integer brandName ;

    private Integer itemId;

    private Integer count;

    private String userId;

    private BigDecimal price;

    private BigDecimal activityPrice;

    private Integer point;

    private Integer activityPoint;

    private Integer activityId;

    private Date createTime;

    private String type;

    private double totalPrice;

    private Integer payId;

    private Integer addId;

    private Integer distributionId;

    private String state ;




    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Integer getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(Integer distributionId) {
        this.distributionId = distributionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getActivityPoint() {
        return activityPoint;
    }

    public void setActivityPoint(Integer activityPoint) {
        this.activityPoint = activityPoint;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }





}
