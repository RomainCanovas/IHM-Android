package com.example.canor.android.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.canor.android.R;
import com.example.canor.android.model.Category;

import java.util.List;

/**
 * Created by canor on 28/05/2017.
 */

public class SettingsPrefAdapter extends ArrayAdapter<Category> {

    private Switch pref;
    public static boolean isPref = true;

    public SettingsPrefAdapter(@NonNull Context context, List<Category> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.pref, null);
        }
        Category category = getItem(position);
        pref = (Switch) convertView.findViewById(R.id.subCat);
        pref.setText(category.getName());
        pref.setChecked(true);
        pref.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isPref) {
                    isPref = false;
                } else {
                    isPref = true;
                }
            }
        });


        return convertView;
    }

    public static boolean getIsPref() {
        return isPref;
    }

}