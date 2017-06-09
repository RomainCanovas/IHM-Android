package com.example.canor.android.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by canor on 28/05/2017.
 */

public class Wishlist {

    private static List<Article> wishArticles = new ArrayList<>();

    public Wishlist() {
    }

    public static List<Article> getWishArticles() {
        return wishArticles;
    }


    public static void addArticleWish(Article article) {
        for (Article s : wishArticles) {
            if (s.equals(article) || s.getId().equals(article.getId())) {
                return;
            }
        }
        wishArticles.add(article);
    }
}
