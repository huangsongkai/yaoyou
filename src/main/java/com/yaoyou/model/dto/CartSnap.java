package com.yaoyou.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by song on 16/8/9.
 */
public class CartSnap {
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemSnapId() {
        return itemSnapId;
    }

    public void setItemSnapId(Integer itemSnapId) {
        this.itemSnapId = itemSnapId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private Integer itemId;
    private Integer itemSnapId;
    private Integer count;
    private BigDecimal price;
}
