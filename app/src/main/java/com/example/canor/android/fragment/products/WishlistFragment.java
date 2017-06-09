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
import com.example.canor.android.adapters.recyclers.ArticlesRecyclerAdapter;
import com.example.canor.android.model.Article;
import com.example.canor.android.model.Wishlist;

import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class WishlistFragment extends Fragment {

    public WishlistFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<Article> articles;
        articles = Wishlist.getWishArticles();
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);
        getActivity().setTitle("Ma liste d'envie");
        ArticlesRecyclerAdapter customAdapter = new ArticlesRecyclerAdapter(articles);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        RecyclerView.LayoutManager layout = new GridLayoutManager(this.getContext(), 1);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(customAdapter);
        return rootView;
    }
}
