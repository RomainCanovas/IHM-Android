package com.example.canor.android.fragment.settings;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.canor.android.R;
import com.example.canor.android.adapters.SettingsPrefAdapter;
import com.example.canor.android.database.DatabaseCategories;
import com.example.canor.android.model.Category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class SettingsCategoryFragment extends Fragment {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pref_list, container, false);
        String name = SettingsFragment.getNamePref();
        DatabaseCategories databaseCategories = new DatabaseCategories(getContext());
        List<Category> categories = new ArrayList<>();
        try {
            databaseCategories.createDataBase();
            databaseCategories.openDataBase();
            switch (name) {
                case "Musique":
                    categories = databaseCategories.getAllMusicCategories();
                    break;
                case "Livres":
                    categories = databaseCategories.getAllBooksCategories();
                    break;
                case "Enfants":
                    categories = databaseCategories.getAllChildCategories();
                    break;
                case "Développement":
                    categories = databaseCategories.getDvpCategories();
                    break;
                case "Evenements":
                    categories = databaseCategories.getEventCategories();
                    break;
            }

            databaseCategories.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        getActivity().setTitle(name.toUpperCase());
        SettingsPrefAdapter customAdapter = new SettingsPrefAdapter(getActivity(), categories);
        ListView listView = (ListView) rootView.findViewById(R.id.listPref);
        listView.setAdapter(customAdapter);
        return rootView;
    }
}
