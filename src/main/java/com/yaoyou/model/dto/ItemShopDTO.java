package com.yaoyou.model.dto;

import com.yaoyou.util.gps.GPS;
import com.yaoyou.util.gps.GPSComparator;

import java.math.BigDecimal;

/**
 * Created by song on 16/8/14.
 */
public class ItemShopDTO implements GPS {

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(Integer storageCount) {
        this.storageCount = storageCount;
    }

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

    private Integer itemId;

    private BigDecimal price;

    private Integer storageCount;

    private String shopInfoId;

    private String shopName;

    private String shopAddress;

    private String shopTel;

    private String isSend;

    private String imgUrl;

    private BigDecimal gpsX;

    private BigDecimal gpsY;
}
