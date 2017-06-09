package com.example.canor.android.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canor on 28/05/2017.
 */

public class Preferences {

    public Preferences() {

    }

    static List<String> preferences = new ArrayList<>();


    public static void createPrefInit() {
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
        preferences.add("1");
    }

    public static void uptadePref(int nb, String value) {
        preferences.set(nb, value);
    }

}
