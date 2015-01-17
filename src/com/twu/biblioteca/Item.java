package com.twu.biblioteca;

/**
 * Created by abhinaym on 16/01/15.
 */
public abstract class Item {

    String name;
    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
