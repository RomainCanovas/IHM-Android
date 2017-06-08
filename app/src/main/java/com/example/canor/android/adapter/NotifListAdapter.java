package com.example.canor.android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.canor.android.R;
import com.example.canor.android.model.Notification;

import java.util.Calendar;
import java.util.List;


public class NotifListAdapter extends ArrayAdapter<Notification>{


    public NotifListAdapter(@NonNull Context context, List<Notification> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Calendar c = Calendar.getInstance();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.notif, null);
        }
        Notification notification =getItem(position);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(notification.getArticle().getTitle());
        TextView desc = (TextView) convertView.findViewById(R.id.desc);
        desc.setText(notification.getArticle().getDescription());
        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(""+c.get(Calendar.DATE)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR));
        TextView heure = (TextView) convertView.findViewById(R.id.hour);
        heure.setText(""+c.get(Calendar.HOUR)+"h"+c.get(Calendar.MINUTE)+"mn"+c.get(Calendar.SECOND)+"sec");
        return convertView;
    }

}