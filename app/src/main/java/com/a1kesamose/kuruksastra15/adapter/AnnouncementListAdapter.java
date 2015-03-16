package com.a1kesamose.kuruksastra15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.Objects.Announcement;
import com.a1kesamose.kuruksastra15.R;

import java.util.List;

public class AnnouncementListAdapter extends BaseAdapter
{
    private Context context;
    private List<Announcement> list;
    private LayoutInflater inflater;

    public AnnouncementListAdapter(Context context, List<Announcement> list)
    {
        this.context = context;
        this.list = list;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = inflater.inflate(R.layout.list_item_announcement, parent, false);
        TextView textViewCluster = (TextView)convertView.findViewById(R.id.textView_cluster_list_item_announcement);
        TextView textViewAnnouncement = (TextView)convertView.findViewById(R.id.textView_announcement_list_item_announcement);
        TextView textViewTime = (TextView)convertView.findViewById(R.id.textView_time_list_item_announcement);
        textViewCluster.setText(list.get(position).ANNOUNCEMENT_CLUSTER);
        textViewAnnouncement.setText(list.get(position).ANNOUNCEMENT_CONTENT);
        textViewTime.setText(list.get(position).ANNOUNCEMENT_TIME);

        return convertView;
    }
}
