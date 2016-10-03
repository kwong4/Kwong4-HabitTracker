package com.example.kwong4.kwong4_habittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Wookiez on 10/3/2016.
 * Majority of code from http://stackoverflow.com/questions/2265661/how-to-use-arrayadaptermyclass
 */
public class CompletionViewAdapter extends ArrayAdapter<Habit> {

    private static class ViewHolder {
        private TextView itemView;
    }

    public CompletionViewAdapter(Context context, int textViewResourceId, ArrayList<Habit> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.history_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.itemView = (TextView) convertView.findViewById(R.id.completion);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Habit item = getItem(position);
        if (item!= null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            viewHolder.itemView.setText(String.format("%s\n%s", item.getName(), dateFormat.format(item.getDate())));
        }

        return convertView;
    }
}
