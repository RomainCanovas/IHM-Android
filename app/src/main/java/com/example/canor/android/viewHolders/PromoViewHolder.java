package com.example.canor.android.viewHolders;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.canor.android.R;
import com.example.canor.android.fragment.categories.SubCategoryFragment;
import com.example.canor.android.fragment.products.PromosFragment;
import com.example.canor.android.model.Category;
import com.squareup.picasso.Picasso;

/**
 * Created by Romain on 04/06/2017.
 */

public class PromoViewHolder extends RecyclerView.ViewHolder {

    private static Context context;
    private static String name;

    public PromoViewHolder(View itemView) {
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
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new PromosFragment())
                        .addToBackStack("")
                        .commit();

            }
        });
    }
    public String getName() {
        return name;
    }

}
