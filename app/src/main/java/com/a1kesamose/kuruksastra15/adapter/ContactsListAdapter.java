package com.a1kesamose.kuruksastra15.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a1kesamose.kuruksastra15.R;

/**
 * Created by Achyuth on 11-Mar-15.
 */
public class ContactsListAdapter extends BaseAdapter
{

    String[] contactHeaders = {"Overall Cultural Co-ordinator", "", "Media", "","","Thespian", "", "","English Lits", "","","Tamil Lits", "","","Hindi Lits","","",
            "Telugu Lits","","", "Eastern Dance","", "Western Dance", "", "", "Music", "", "", "Fine Arts", "", "", "Marketing", "", "", "Hospitality", "", "Publicity", "",
            "Public Relations", "", "Crowd Control", "", "", "Infrastructure", "", "", "Merchandise", "",""};

    String[] contactNames = {"Aditya Durai", "Nikilav. P. V.", "Venkat", "Anuraag Vikram Kate", "Lakshminarayanan", "Anirudh. C. S.", "Arjun",
            "Nandha", "Ramki", "Asif Ahmed", "Amrita Kesari", "Bhuvana Mitra", "Shivaprakash", "Swetha", "Sanjai Prabo", "Adithya",
            "Adhithya", "Anirudh", "Syed Ajmal", "Vinushitha", "Abhijit", "Akash Shankar", "Bhuvaneshwaran", "Raja Kumaran", "Vishal", "Deva Saravanan", "Raghuraman Srinivasan",
            "Kissanth Tamilselvan", "Ayush Krishnan", "Nitesh Sekar", "Barani Dharan"};

    String[] contactNumbers = {"+91 9566145762", "+91 9500140315", "+91 9488813070", "+91 9585912813", "+91 8122146785", "+91 9940467937", "+91 9884010680", "+91 8122486508", "+91 9003565966",
            "+91 9003343773", "+91 9597886736", "+91 7708073118", "+91 8754627553", "+91 9710926781", "+91 9894755668", "+91 9940032091", "+91 9500482868", "+91 9789819309",
            "+91 9790893730", "+91 9786066980", "+91 9500165092", "+91 9840925092", "+91 9367623888", "+91 8056975409", "+91 9677052091", "+91 9659047060", "+91 9094911674",
            "+91 7200236463", "+91 9629980718", "+91 9865786572" , "+91 9488255669"};


    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private int[] rowState;
    private Context context;

    public ContactsListAdapter(Context context)
    {
        this.context = context;
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

        if(showSeparator)
        {
            sectionLayout.setVisibility(View.VISIBLE);
            sectionName.setText(contactHeaders[position]);
        }
        else
        {
            sectionLayout.setVisibility(View.GONE);
        }

        return contactView;
    }
}
