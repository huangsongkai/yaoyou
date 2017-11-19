package com.yaoyou.model.dataObject;

import java.math.BigDecimal;

/**
 * Created by song on 16/7/28.
 */
public class IdRatePair {
    String id;

    double rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate.doubleValue();
    }

}
