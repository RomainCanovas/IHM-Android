package com.example.canor.android.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.canor.android.R;
import com.example.canor.android.asyncTask.ImageAsyncTask;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.listener.CheckboxListener;
import com.example.canor.android.model.Article;
import com.example.canor.android.viewHolder.ArticlesViewHolder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleFragment extends Fragment {
    public ArticleFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article, container, false);
        DatabaseArticles databaseArticles = new DatabaseArticles(getContext());
        Article article=new Article("","","","","","","","","","","","");
        try {
            databaseArticles.createDataBase();
            databaseArticles.openDataBase();
            article = databaseArticles.getArticle(new ArticlesViewHolder(rootView).getID());
            databaseArticles.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        ImageAsyncTask imageAsyncTask;
        TextView name = (TextView) rootView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageButton);
        assert article != null;
        name.setText(article.getTitle());
        TextView category = (TextView) rootView.findViewById(R.id.category);
        if(article.getSubCategory()!=null){
            category.setText(article.getCategory().toUpperCase()+"/"+article.getSubCategory().toUpperCase());
        }
        else category.setText(article.getCategory().toUpperCase());
        TextView author = (TextView) rootView.findViewById(R.id.author);
        author.setText(article.getAuthor());
        TextView price = (TextView) rootView.findViewById(R.id.price);
        price.setText(article.getPrice());
        TextView description = (TextView) rootView.findViewById(R.id.desc);
        description.setText(article.getDescription());
        String mStock = article.getStock();
        TextView stock = (TextView) rootView.findViewById(R.id.stock);
        if(mStock.equals(0)){
            stock.setText("Cet article est épuisé");
        }
        else stock.setText("En stock");
        CheckBox box= (CheckBox) rootView.findViewById(R.id.wishlist);
        box.setOnClickListener(new CheckboxListener(box, article));
        imageAsyncTask = new ImageAsyncTask(imageView);
        imageAsyncTask.execute(article.getPic());
        return rootView;
    }


}
