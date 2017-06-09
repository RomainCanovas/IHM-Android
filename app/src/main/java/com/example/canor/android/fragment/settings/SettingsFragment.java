package com.example.canor.android.fragment.settings;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.canor.android.R;

/**
 * Created by canor on 28/05/2017.
 */

public class SettingsFragment extends Fragment {

    Button music;
    Button books;
    Button dvp;
    Button events;
    Button children;
    Switch notif;

    static boolean isNotif;
    static String namePref;


    public SettingsFragment() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final android.app.FragmentManager manager = getActivity().getFragmentManager();
        View rootView = inflater.inflate(R.layout.settings_main, container, false);

        music = (Button) rootView.findViewById(R.id.musicButton);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePref = "Musique";
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new SettingsCategoryFragment())
                        .addToBackStack("")
                        .commit();
            }
        });

        books = (Button) rootView.findViewById(R.id.booksbutton);
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePref = "Livres";
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new SettingsCategoryFragment())
                        .addToBackStack("")
                        .commit();
            }
        });

        children = (Button) rootView.findViewById(R.id.childrenButton);
        children.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePref = "Enfants";
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new SettingsCategoryFragment())
                        .addToBackStack("")
                        .commit();
            }
        });


        dvp = (Button) rootView.findViewById(R.id.dvpButton);
        dvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePref = "Stages";
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new SettingsCategoryFragment())
                        .addToBackStack("")
                        .commit();
            }
        });


        events = (Button) rootView.findViewById(R.id.eventButton);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namePref = "Evenements";
                manager.beginTransaction()
                        .replace(R.id.content_frame
                                , new SettingsCategoryFragment())
                        .addToBackStack("")
                        .commit();
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

    public static boolean getIsNotif() {
        return isNotif;
    }

    public static String getNamePref() {
        return namePref;
    }


}
