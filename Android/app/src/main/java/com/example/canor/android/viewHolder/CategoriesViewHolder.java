package com.example.canor.android.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.canor.android.MainActivity;
import com.example.canor.android.R;
import com.example.canor.android.asyncTask.ImageAsyncTask;
import com.example.canor.android.fragment.articles.other.DvpFragment;
import com.example.canor.android.fragment.articles.other.EventFragment;
import com.example.canor.android.fragment.category.BooksFragment;
import com.example.canor.android.fragment.category.ChildrenFragment;
import com.example.canor.android.fragment.category.MusicFragment;
import com.example.canor.android.model.Category;

/**
 * Created by Romain on 04/06/2017.
 */

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    private static Context context;
    private static String name;

    public CategoriesViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public void setItem(final Category category) {
        ImageButton img = (ImageButton) this.itemView.findViewById(R.id.cate);
        ImageAsyncTask imageAsyncTask = new ImageAsyncTask(img);
        imageAsyncTask.execute(category.getPic());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = category.getName();
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                switch (name) {
                    case "Musique":
                        //Toast.makeText(context, (int) itemView.getRotation(), Toast.LENGTH_SHORT).show();
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new MusicFragment())
                                .commit();
                        break;
                    case "Livres":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new BooksFragment())
                                .commit();
                        break;
                    case "Enfants":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new ChildrenFragment())
                                .commit();
                        break;
                    case "Développement":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new DvpFragment())
                                .commit();
                        break;
                    case "Evenements":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new EventFragment())
                                .commit();
                        break;
                }
            }
        });
    }

    public String getName() {
        return name;
    }
}


//Toast.makeText(context, category.getName(), Toast.LENGTH_SHORT).show();
