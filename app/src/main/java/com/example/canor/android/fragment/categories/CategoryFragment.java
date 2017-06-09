package com.example.canor.android.fragment.categories;

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
import com.example.canor.android.adapters.recyclers.SubCategoriesRecyclerAdapter;
import com.example.canor.android.database.DatabaseCategories;
import com.example.canor.android.model.Category;
import com.example.canor.android.viewHolders.CategoriesViewHolder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class CategoryFragment extends Fragment {
    public CategoryFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        String name = new CategoriesViewHolder(rootView).getName();
        DatabaseCategories databaseCategories = new DatabaseCategories(getContext());
        List<Category> categories = new ArrayList<>();
        try {
            databaseCategories.createDataBase();
            databaseCategories.openDataBase();
            switch (name) {
                case "Musique":
                    categories = databaseCategories.getAllMusicCategories();
                    break;
                case "Livres":
                    categories = databaseCategories.getAllBooksCategories();
                    break;
                case "Enfants":
                    categories = databaseCategories.getAllChildCategories();
                    break;
            }
            databaseCategories.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        getActivity().setTitle(name.toUpperCase());
        SubCategoriesRecyclerAdapter customAdapter = new SubCategoriesRecyclerAdapter(categories);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;
    }

}
