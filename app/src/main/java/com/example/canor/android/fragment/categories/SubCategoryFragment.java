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
import com.example.canor.android.adapters.recyclers.ArticlesRecyclerAdapter;
import com.example.canor.android.database.DatabaseSubCategories;
import com.example.canor.android.model.Article;
import com.example.canor.android.viewHolders.SubCategoriesViewHolder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class SubCategoryFragment extends Fragment {
    public SubCategoryFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        String name = new SubCategoriesViewHolder(rootView).getName();
        DatabaseSubCategories databaseSubCategories = new DatabaseSubCategories(getContext());
        List<Article> articles = new ArrayList<>();
        try {
            databaseSubCategories.createDataBase();
            databaseSubCategories.openDataBase();
            switch (name) {
                case "musique":
                    articles = databaseSubCategories.getAllMusicArticles();
                    break;
                case "livres":
                    articles = databaseSubCategories.getAllBooksArticles();
                    break;
                case "jeux":
                    articles = databaseSubCategories.getAllGamesArticles();
                    break;
                case "sciences":
                    articles = databaseSubCategories.getAllSciencesArticles();
                    break;
                case "roman":
                    articles = databaseSubCategories.getAllRomansArticles();
                    break;
                case "thriller":
                    articles = databaseSubCategories.getAllThrillersArticles();
                    break;
                case "bd":
                    articles = databaseSubCategories.getAllBDArticles();
                    break;
                case "jeunesse":
                    articles = databaseSubCategories.getAllJeunesseArticles();
                    break;
                case "dictionnaire":
                    articles = databaseSubCategories.getAllDicoArticles();
                    break;
                case "histoire":
                    articles = databaseSubCategories.getAllHistoryArticles();
                    break;
                case "varfr":
                    articles = databaseSubCategories.getAllVarFrArticles();
                    break;
                case "varint":
                    articles = databaseSubCategories.getAllVarIntArticles();
                    break;
                case "electro":
                    articles = databaseSubCategories.getAllElectroArticles();
                    break;
                case "reggae":
                    articles = databaseSubCategories.getAllReggaeArticles();
                    break;
                case "jazz":
                    articles = databaseSubCategories.getAllJazzArticles();
                    break;
                case "classique":
                    articles = databaseSubCategories.getAllClassiqueArticles();
                    break;
                case "film":
                    articles = databaseSubCategories.getAllFilmsArticles();
                    break;
                case "rock":
                    articles = databaseSubCategories.getAllRockArticles();
                    break;
            }
            databaseSubCategories.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        getActivity().setTitle(name.toUpperCase());
        ArticlesRecyclerAdapter customAdapter = new ArticlesRecyclerAdapter(articles);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;
    }

}