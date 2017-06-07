package com.example.canor.android.viewHolder;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.canor.android.R;
import com.example.canor.android.fragment.articles.books.BDFragment;
import com.example.canor.android.fragment.articles.books.DictionnairesFragment;
import com.example.canor.android.fragment.articles.books.HistoireFragment;
import com.example.canor.android.fragment.articles.books.JeunesseFragment;
import com.example.canor.android.fragment.articles.books.RomansFragment;
import com.example.canor.android.fragment.articles.books.ThrillersFragment;
import com.example.canor.android.fragment.articles.children.GamesFragment;
import com.example.canor.android.fragment.articles.children.SciencesFragment;
import com.example.canor.android.fragment.articles.music.ClassicFragment;
import com.example.canor.android.fragment.articles.music.ElectroFragment;
import com.example.canor.android.fragment.articles.music.FilmsFragment;
import com.example.canor.android.fragment.articles.music.JazzFragment;
import com.example.canor.android.fragment.articles.music.ReggaeFragment;
import com.example.canor.android.fragment.articles.music.RockFragment;
import com.example.canor.android.fragment.articles.music.VarFrFragment;
import com.example.canor.android.fragment.articles.music.VarIntFragment;
import com.example.canor.android.model.Category;
import com.squareup.picasso.Picasso;

/**
 * Created by Romain on 04/06/2017.
 */

public class SubCategoriesViewHolder extends RecyclerView.ViewHolder {

    private static Context context;

    public SubCategoriesViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    public void setItem(final Category category) {
        ImageButton img = (ImageButton) this.itemView.findViewById(R.id.cate);
        Picasso.with(context).load(category.getPic()).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = category.getName();
                android.app.FragmentManager manager = ((Activity) context).getFragmentManager();
                switch (name) {
                    case "musique":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new com.example.canor.android.fragment.articles.children.MusicFragment())
                                .addToBackStack("")
                                .commit();
                        break;
                    case "livres":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new com.example.canor.android.fragment.articles.children.BooksFragment())
                                .addToBackStack("")
                                .commit();
                        break;
                    case "jeux":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new GamesFragment())
                                .addToBackStack("")
                                .commit();
                        break;
                    case "sciences":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new SciencesFragment())
                                .addToBackStack("")
                                .commit();
                    case "roman":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new RomansFragment())
                                .addToBackStack("")
                                .commit();
                    case "thriller":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new ThrillersFragment())
                                .addToBackStack("")
                                .commit();
                    case "bd":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new BDFragment())
                                .addToBackStack("")
                                .commit();
                    case "jeunesse":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new JeunesseFragment())
                                .addToBackStack("")
                                .commit();
                    case "dictionnaire":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new DictionnairesFragment())
                                .addToBackStack("")
                                .commit();
                    case "histoire":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new HistoireFragment())
                                .addToBackStack("")
                                .commit();
                    case "varfr":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new VarFrFragment())
                                .addToBackStack("")
                                .commit();
                    case "varint":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new VarIntFragment())
                                .addToBackStack("")
                                .commit();
                    case "electro":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new ElectroFragment())
                                .addToBackStack("")
                                .commit();
                    case "reggae":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new ReggaeFragment())
                                .addToBackStack("")
                                .commit();
                    case "jazz":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new JazzFragment())
                                .addToBackStack("")
                                .commit();
                    case "classique":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new ClassicFragment())
                                .addToBackStack("")
                                .commit();
                    case "film":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new FilmsFragment())
                                .addToBackStack("")
                                .commit();
                    case "rock":
                        manager.beginTransaction()
                                .replace(R.id.content_frame
                                        , new RockFragment())
                                .addToBackStack("")
                                .commit();

                }
            }
        });
    }
}
