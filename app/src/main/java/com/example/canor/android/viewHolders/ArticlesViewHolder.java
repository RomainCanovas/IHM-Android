package com.example.canor.android.viewHolders;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.canor.android.MainActivity;
import com.example.canor.android.R;
import com.example.canor.android.fragment.ArticleFragment;
import com.example.canor.android.model.Article;
import com.squareup.picasso.Picasso;

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
        if (MainActivity.orientation == 2) {
            ((TextView) this.itemView.findViewById(R.id.stock)).setText("En stock");
            ((TextView) this.itemView.findViewById(R.id.desc)).setText(article.getDescription());
        }
        if (article.getPromo().equals("1")){
            this.itemView.findViewById(R.id.promo).setVisibility(View.VISIBLE);
            this.itemView.findViewById(R.id.price2).setVisibility(View.VISIBLE);
            TextView newPrice = ((TextView) this.itemView.findViewById(R.id.price));
            TextView oldPrice = ((TextView) this.itemView.findViewById(R.id.price2));
            newPrice.setText(article.getPricePromo());
            newPrice.setTextColor(context.getResources().getColor(R.color.colorPromo));
            oldPrice.setText(article.getPrice());
            oldPrice.getPaint().setStrikeThruText(true);
        }
        else {
            this.itemView.findViewById(R.id.promo).setVisibility(View.INVISIBLE);
            this.itemView.findViewById(R.id.price2).setVisibility(View.INVISIBLE);
            TextView price = (TextView) this.itemView.findViewById(R.id.price);
            price.setText(article.getPrice());
            price.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }
        if (article.getNews().equals("1")){
            this.itemView.findViewById(R.id.news).setVisibility(View.VISIBLE);
        }
        else{
            this.itemView.findViewById(R.id.news).setVisibility(View.INVISIBLE);
        }

        ImageView img = (ImageView) this.itemView.findViewById(R.id.pic);
        Picasso.with(context).load(article.getPic()).into(img);
        Button button = (Button) this.itemView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = article.getId();
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new ArticleFragment())
                        .addToBackStack("")
                        .commit();
            }

        });
    }
}
