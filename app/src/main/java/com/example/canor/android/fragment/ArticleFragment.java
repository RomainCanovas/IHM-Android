package com.example.canor.android.fragment;

import android.app.Fragment;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.canor.android.R;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.listeners.CheckboxListener;
import com.example.canor.android.model.Article;
import com.example.canor.android.viewHolders.ArticlesViewHolder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by canor on 28/05/2017.
 */

public class ArticleFragment extends Fragment {
    public ArticleFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article, container, false);
        DatabaseArticles databaseArticles = new DatabaseArticles(getContext());
        Article article = new Article("", "", "", "", "", "", "", "", "", "", "", "");
        try {
            databaseArticles.createDataBase();
            databaseArticles.openDataBase();
            article = databaseArticles.getArticle(new ArticlesViewHolder(rootView).getID());
            databaseArticles.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageButton);
        assert article != null;
        TextView name = (TextView) rootView.findViewById(R.id.title);
        name.setPaintFlags(name.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Dosis-Bold.ttf");
        name.setTypeface(face);
        name.setText(article.getTitle());
        TextView category = (TextView) rootView.findViewById(R.id.category);
        if (article.getSubCategory() != null) {
            category.setTypeface(face);
            category.setText(article.getCategory().toUpperCase() + "/" + article.getSubCategory().toUpperCase());
        } else category.setText(article.getCategory().toUpperCase());
        TextView author = (TextView) rootView.findViewById(R.id.author);
        author.setTypeface(face);
        author.setText(article.getAuthor());
        if (article.getPromo().equals("1")) {
            rootView.findViewById(R.id.promo).setVisibility(View.VISIBLE);
            TextView promo = ((TextView) rootView.findViewById(R.id.promo));
            promo.setTypeface(face);
            rootView.findViewById(R.id.price2).setVisibility(View.VISIBLE);
            TextView newPrice = ((TextView) rootView.findViewById(R.id.price));
            TextView oldPrice = ((TextView) rootView.findViewById(R.id.price2));
            newPrice.setText(article.getPricePromo());
            newPrice.setTextColor(getResources().getColor(R.color.colorPromo));
            oldPrice.setText(article.getPrice());
            oldPrice.getPaint().setStrikeThruText(true);
        } else {
            rootView.findViewById(R.id.promo).setVisibility(View.INVISIBLE);
            rootView.findViewById(R.id.price2).setVisibility(View.INVISIBLE);
            TextView price = (TextView) rootView.findViewById(R.id.price);
            price.setText(article.getPrice());
            price.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        if (article.getNews().equals("1")) {
            rootView.findViewById(R.id.news).setVisibility(View.VISIBLE);
            TextView news = ((TextView) rootView.findViewById(R.id.news));
            news.setTypeface(face);
        } else {
            rootView.findViewById(R.id.news).setVisibility(View.INVISIBLE);
        }
        TextView description = (TextView) rootView.findViewById(R.id.desc);
        Typeface face2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Dosis-Regular.ttf");
        description.setTypeface(face2);
        description.setText(article.getDescription());
        TextView stock = (TextView) rootView.findViewById(R.id.stock);
        description.setTypeface(face);
        if (article.getStock().equals("0")) {
            stock.setText(R.string.outOfstock);
        } else stock.setText(R.string.inStock);
        CheckBox box = (CheckBox) rootView.findViewById(R.id.wishlist);
        box.setOnClickListener(new CheckboxListener(box, article));
        Picasso.with(getActivity()).load(article.getPic()).into(imageView);
        return rootView;
    }


}
