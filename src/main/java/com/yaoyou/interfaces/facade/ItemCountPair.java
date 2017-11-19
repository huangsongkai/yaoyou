package com.yaoyou.interfaces.facade;

/**
 * Created by song on 16/8/11.
 */
public class ItemCountPair {
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int itemId;
    int count;
}
