package com.example.canor.android.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.canor.android.R;
import com.example.canor.android.database.DatabaseArticles;
import com.example.canor.android.listeners.CheckboxListener;
import com.example.canor.android.model.Article;
import com.example.canor.android.model.Preferences;
import com.example.canor.android.viewHolder.ArticlesViewHolder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by canor on 08/06/2017.
 */

public class SettingsFragment extends Fragment {

    Button music;
    Button books;
    Button dvp;
    Button events;
    Button children;
    Switch notif;

    static boolean isNotif;


    public SettingsFragment() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_main, container, false);
        music = (Button) rootView.findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        notif = (Switch) rootView.findViewById(R.id.notifSwitch);
        notif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isNotif) {
                    isNotif = false;
                } else {
                    isNotif = true;
                }
            }
        });
        return rootView;
    }

    public static boolean getIsNotif(){
        return isNotif;
    }

}
