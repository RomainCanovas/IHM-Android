package com.example.canor.android.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.canor.android.MainActivity;
import com.example.canor.android.R;
import com.example.canor.android.asyncTask.ImageAsyncTask;
import com.example.canor.android.fragment.ArticleFragment;
import com.example.canor.android.model.Article;

/**
 * Created by Romain on 04/06/2017.
 */

public class ArticlesViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener{

    private static Context context;
    private static String id;

    public ArticlesViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public String getID() {
        return id;
    }

    public void setItem(final Article article) {
        ((TextView) this.itemView.findViewById(R.id.title)).setText(article.getTitle());
        ((TextView) this.itemView.findViewById(R.id.author)).setText(article.getAuthor());
        ((TextView) this.itemView.findViewById(R.id.price)).setText(article.getPrice());
        if (MainActivity.orientation == 2) {
            ((TextView) this.itemView.findViewById(R.id.stock)).setText("En stock");
            ((TextView) this.itemView.findViewById(R.id.desc)).setText(article.getDescription());
        }

        ImageView img = (ImageView) this.itemView.findViewById(R.id.pic);
        ImageAsyncTask imageAsyncTask = new ImageAsyncTask(img);
        imageAsyncTask.execute(article.getPic());
        Button button = (Button) this.itemView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = article.getId();
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new ArticleFragment())//.addToBackStack("tag")
                        .commit();
            }

        });
    }
}
