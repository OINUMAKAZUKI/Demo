package com.namanuma.model;

/**
 * Created by oinumakazuki on 2016/07/05.
 */
public class Item {
    private String name;
    private int activity_type;

    public Item(String name) {
        this.name = name;
        this.activity_type = -1;
    }

    public Item(String name, int activity_type) {
        this.name = name;
        this.activity_type = activity_type;
    }

    public String getName() {
        return name;
    }

    public int getActivityType() {
        return activity_type;
    }
}
