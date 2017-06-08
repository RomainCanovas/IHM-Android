package com.example.canor.android.fragment.articles.general;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.canor.android.R;
import com.example.canor.android.adapter.ArticlesRecyclerAdapter;
import com.example.canor.android.adapter.NotifListAdapter;
import com.example.canor.android.model.Notification;

import java.util.List;

/**
 * Created by Romain on 04/06/2017.
 */

public class NotifFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.notif_list, container, false);
        getActivity().setTitle("Historique de notifications");
        NotifListAdapter customAdapter = new NotifListAdapter(getActivity(),Notification.getNotif());
        ListView gridView = (ListView) rootView.findViewById(R.id.listNotif);
        gridView.setAdapter(customAdapter);
        return rootView;
    }
}
