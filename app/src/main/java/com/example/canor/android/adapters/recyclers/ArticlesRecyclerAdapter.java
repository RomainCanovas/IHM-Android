package com.example.canor.android.adapters.recyclers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.canor.android.R;
import com.example.canor.android.model.Article;
import com.example.canor.android.viewHolders.ArticlesViewHolder;

import java.util.List;

/**
 * Created by canor on 28/05/2017.
 */

public class ArticlesRecyclerAdapter extends RecyclerView.Adapter<ArticlesViewHolder> {
    private List<Article> articles;

    public ArticlesRecyclerAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new ArticlesViewHolder(inflater.inflate(R.layout.element, null));
    }

    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        holder.setItem(articles.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
