package com.example.canor.android.fragment.articles.general;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.canor.android.R;
import com.example.canor.android.adapter.ArticlesRecyclerAdapter;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.model.Article;
import com.example.canor.android.viewHolder.CategoriesViewHolder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class PromosFragment extends Fragment {
    public PromosFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DatabaseArticles databaseArticles = new DatabaseArticles(getContext());
        List<Article> articles = new ArrayList<>();
        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        String name = new CategoriesViewHolder(rootView).getName();
        try {
            databaseArticles.createDataBase();
            databaseArticles.openDataBase();
            switch (name) {
                case "Musique":
                    articles = databaseArticles.getPromoMusicArticle();
                    break;
                case "Livres":
                    articles = databaseArticles.getPromoBooksArticle();
                    break;
                case "Enfants":
                    articles = databaseArticles.getPromoChildArticle();
                    break;
                case "Développement":
                    articles = databaseArticles.getPromoDvpArticle();
                    break;
                case "Evenements":
                    articles = databaseArticles.getPromoEventArticle();
                    break;
            }
            databaseArticles.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        getActivity().setTitle(name);
        ArticlesRecyclerAdapter customAdapter = new ArticlesRecyclerAdapter(articles);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;

    }

}
