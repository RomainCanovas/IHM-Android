package com.example.canor.android.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canor on 08/06/2017.
 */

public class Notification extends android.app.Notification{

    private Article article;
    private String name;
    static List<Notification> notifications=new ArrayList<>();

    public Notification(Article article, String name) {
        this.article = article;
        this.name = name;
    }

    public Article getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public static void updateNotif(List<Notification> newNotifs){
        for(Notification n : newNotifs) {
            notifications.add(n);
        }
    }

    public static List<Notification> getNotif(){
        return notifications;
    }
}
