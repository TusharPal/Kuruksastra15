package com.a1kesamose.kuruksastra15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.holder.ViewHolder;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Achyuth on 11-Mar-15.
 */
public class ContactsListAdapter extends BaseAdapter
{

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private int[] rowState;
    private Context context;
    String[] contactHeaders;
    String[] contactNames;
    String[] contactNumbers;

    public ContactsListAdapter(Context context, String[] contactHeaders, String[] contactNames, String[] contactNumbers)
    {
        this.context = context;
        this.contactNames = contactNames;
        this.contactHeaders = contactHeaders;
        this.contactNumbers = contactNumbers;
        rowState = new int[getCount()];
    }

    @Override
    public int getViewTypeCount()
    {
        return 2;
    }

    @Override
    public int getCount() {
        return contactNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View contactView;
        boolean showSeparator = false;

        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            contactView = layoutInflater.inflate(R.layout.list_item_contact, null);
        }
        else
        {
            contactView = convertView;
        }

        TextView contactName = (TextView)contactView.findViewById(R.id.contact_name);
        TextView contactNumber = (TextView)contactView.findViewById(R.id.contact_number);
        contactName.setText(contactNames[position]);
        contactNumber.setText(contactNumbers[position]);

        switch (rowState[position])
        {
            case TYPE_SEPARATOR:
                showSeparator = true;
                break;
            case TYPE_ITEM:
                showSeparator = false;
                break;
            default:
                if(position==0 || position==1 || position==3 || position==5 || position==7 || position==9 || position==11 || position==13 || position==14 || position==16 || position==18 || position==20 || position==22 || position==23 || position==24 || position==25 || position==27 || position==29)
                {
                    showSeparator = true;
                }
                rowState[position] = showSeparator ? TYPE_SEPARATOR : TYPE_ITEM;
                break;
        }

        LinearLayout sectionLayout = (LinearLayout)contactView.findViewById(R.id.section_header);
        TextView sectionName = (TextView)contactView.findViewById(R.id.contact_category);
        View separator = (View)contactView.findViewById(R.id.separator);

        return contactView;
    }
}
