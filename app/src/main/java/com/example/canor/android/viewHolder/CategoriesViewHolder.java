package com.example.canor.android.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.canor.android.R;
import com.example.canor.android.fragment.articles.general.OtherFragment;
import com.example.canor.android.fragment.category.CategoryFragment;
import com.example.canor.android.model.Category;
import com.squareup.picasso.Picasso;

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
        Picasso.with(context).load(category.getPic()).into(img);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = category.getName();
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                switch (name) {
                    case "Musique":
                    case "Livres":
                    case "Enfants":
                        //Toast.makeText(context, (int) itemView.getRotation(), Toast.LENGTH_SHORT).show();
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new CategoryFragment())
                                .addToBackStack("")
                                .commit();
                        break;
                    case "Développement":
                    case "Evenements":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new OtherFragment())
                                .addToBackStack("")
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
