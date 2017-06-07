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
import com.example.canor.android.adapter.SubCategoriesRecyclerAdapter;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.database.DatabaseCategories;
import com.example.canor.android.model.Article;
import com.example.canor.android.model.Category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class PromosCategoriesFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DatabaseCategories databaseCategories = new DatabaseCategories(getContext());
        List<Category> categories = new ArrayList<>();
        try {
            databaseCategories.createDataBase();
            databaseCategories.openDataBase();
            categories = databaseCategories.getPromosCategories();
            databaseCategories.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        getActivity().setTitle("Promos");
        SubCategoriesRecyclerAdapter customAdapter = new SubCategoriesRecyclerAdapter(categories);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;

    }
}
