package com.example.canor.android.listeners;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.canor.android.model.Article;
import com.example.canor.android.model.Wishlist;

/**
 * Created by Romain on 04/06/2017.
 */

public class CheckboxListener implements View.OnClickListener {

    private CheckBox checkBox;
    private Article article;
    private static Context context;

    public CheckboxListener(CheckBox checkBox, Article article) {
        this.checkBox = checkBox;
        this.article = article;
        context=checkBox.getContext();
    }

    @Override
    public void onClick(View v) {
        if (this.checkBox.isChecked()) {
            Wishlist.addArticleWish(this.article);
            Toast.makeText(context, "Article ajouté à votre liste d'envie!", Toast.LENGTH_SHORT).show();
        } else if (!this.checkBox.isChecked()) {
            if (Wishlist.getWishArticles().contains(article)) {
                Wishlist.getWishArticles().remove(article);
                Toast.makeText(context, "Article retiré de votre liste d'envie", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
