package com.example.canor.android.adapters.recyclers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.canor.android.R;
import com.example.canor.android.model.Category;
import com.example.canor.android.viewHolders.NewsViewHolder;
import com.example.canor.android.viewHolders.SubCategoriesViewHolder;

import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<Category> categories;

    public NewsRecyclerAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new NewsViewHolder(inflater.inflate(R.layout.category, null));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.setItem(categories.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

}
