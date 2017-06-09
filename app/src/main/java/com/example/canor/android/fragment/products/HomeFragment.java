package com.example.canor.android.fragment.products;

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
import com.example.canor.android.adapters.SettingsPrefAdapter;
import com.example.canor.android.adapters.recyclers.ArticlesRecyclerAdapter;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.model.Article;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by canor on 28/05/2017.
 */

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DatabaseArticles databaseArticles = new DatabaseArticles(getContext());
        List<Article> articles = new ArrayList<>();
        try {
            databaseArticles.createDataBase();
            databaseArticles.openDataBase();
            articles = databaseArticles.getAllArticles();
            databaseArticles.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        if (SettingsPrefAdapter.getIsPref() == false) {
            articles.remove(3);
            articles.remove(3);
        }
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        getActivity().setTitle("Accueil");
        ArticlesRecyclerAdapter customAdapter = new ArticlesRecyclerAdapter(articles);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;

    }

}
