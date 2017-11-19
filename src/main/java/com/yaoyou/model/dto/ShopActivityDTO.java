package com.yaoyou.model.dto;

import java.math.BigDecimal;

/**
 * Created by song on 16/8/24.
 */
public class ShopActivityDTO {

    public String getShopInfoId() {
        return shopInfoId;
    }

    public void setShopInfoId(String shopInfoId) {
        this.shopInfoId = shopInfoId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getGpsX() {
        return gpsX;
    }

    public void setGpsX(BigDecimal gpsX) {
        this.gpsX = gpsX;
    }

    public BigDecimal getGpsY() {
        return gpsY;
    }

    public void setGpsY(BigDecimal gpsY) {
        this.gpsY = gpsY;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public BigDecimal getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(BigDecimal avgRate) {
        this.avgRate = avgRate;
    }

    private String shopInfoId;

    private String shopName;

    private Integer seq;

    private String shopAddress;

    private String shopTel;

    private String isSend;

    private String imgUrl;

    private BigDecimal gpsX;

    private BigDecimal gpsY;

    private String state;

    private Integer activityId;

    private BigDecimal avgRate;

    private BigDecimal distance;

}
