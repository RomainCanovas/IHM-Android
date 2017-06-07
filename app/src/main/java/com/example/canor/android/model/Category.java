package com.example.canor.android.model;

/**
 * Created by Romain on 04/06/2017.
 */

public class Category {
    private String name;
    private String pic;

    public Category(String name, String pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public String getPic() {
        return pic;
    }
}
