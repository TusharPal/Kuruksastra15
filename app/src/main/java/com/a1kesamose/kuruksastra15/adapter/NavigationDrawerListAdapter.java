package com.a1kesamose.kuruksastra15.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;

public class NavigationDrawerListAdapter extends BaseAdapter
{
    private Context context;
    private String icons[];
    private String items[] = {"About KS", "Events", "Announcements", "Pro Shows", "KS Upahaar", "Seniors' Say", "Sponsors", "Contacts", "Schedule", "Day 1", "Day 2", "Day 3","Settings"};
    private LayoutInflater inflater;
    private int itemSelectedPosition;

    Typeface fontAwesomeTypeface;
    private TextView textViewIcon;
    private TextView textViewItem;

    public NavigationDrawerListAdapter(Context context, int itemSelectedPosition)
    {
        this.context = context;
        this.itemSelectedPosition = itemSelectedPosition;
        icons = context.getResources().getStringArray(R.array.icons);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return items.length;
    }

    @Override
    public Object getItem(int position)
    {
        return items[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view = inflater.inflate(R.layout.list_item_navigation_drawer, viewGroup, false);
        textViewIcon = (TextView)view.findViewById(R.id.textView_icon_list_item_navigation_drawer);
        textViewItem = (TextView)view.findViewById(R.id.textView_item_list_item_navigation_drawer);

        fontAwesomeTypeface = Typeface.createFromAsset(context.getAssets(),"fonts/fontawesome-webfont.ttf");
        textViewIcon.setTypeface(fontAwesomeTypeface);

        textViewIcon.setText(icons[position]);
        textViewItem.setText(items[position]);
        if(position == itemSelectedPosition)
        {
            textViewItem.setTextColor(context.getResources().getColor(R.color.yellow));
            view.setBackgroundColor(context.getResources().getColor(R.color.background_dark_grey));
        }

        return view;
    }

    public void setItemSelectedPosition(int position)
    {
        this.itemSelectedPosition = position;
    }
}
