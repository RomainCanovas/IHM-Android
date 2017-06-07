package com.example.canor.android.model;

/**
 * Created by Romain on 04/06/2017.
 */

public class Article {

    private String id;
    private String title;
    private String pic;
    private String author;
    private String description;
    private String price;
    private String category;
    private String subCategory;
    private String stock;
    private String promo;
    private String pricePromo;
    private String news;


    public Article(String id, String title, String pic, String author, String description, String price, String category, String subCategory, String stock, String promo, String pricePromo, String news) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
        this.stock = stock;
        this.promo = promo;
        this.pricePromo = pricePromo;
        this.news = news;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getStock() {
        return stock;
    }

    public String getPromo() {
        return promo;
    }

    public String getPricePromo() {
        return pricePromo;
    }

    public String getNews() {
        return news;
    }
}
