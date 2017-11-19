package com.yaoyou.infrastructure.messaging;

import com.yaoyou.model.dataObject.Item;

/**
 * Created by Administrator on 2016/2/19.
 */
public class AddItemSnap extends DomainEvent {
    private Item item;

    public AddItemSnap(Item item){
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    @Override
    public EventType getEventType() {
        return null;
    }

    @Override
    public boolean sameEventAs(Object other) {
        return false;
    }
}
