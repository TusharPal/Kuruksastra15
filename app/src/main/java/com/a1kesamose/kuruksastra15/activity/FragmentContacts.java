package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.adapter.ContactsListAdapter;
import com.a1kesamose.kuruksastra15.itemInterface.ListItem;
import com.a1kesamose.kuruksastra15.listItemClasses.ContactDetails;
import com.a1kesamose.kuruksastra15.listItemClasses.ContactHeader;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FragmentContacts extends Fragment implements AdapterView.OnItemClickListener
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView contactLogoTextView;
    Typeface fontAwesomeTypeface;
    ContactsListAdapter listAdapter;
    ListView contactsListView;
    ArrayList<ListItem> listItems = new ArrayList<ListItem>();



    public static FragmentContacts newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentContacts fragment = new FragmentContacts();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View contactView = inflater.inflate(R.layout.fragment_contacts, null);

        contactLogoTextView = (TextView)contactView.findViewById(R.id.txt_contact_logo);
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        contactLogoTextView.setTypeface(fontAwesomeTypeface);

        contactsListView = (ListView)contactView.findViewById(R.id.contact_list_view);
        listItems.add(new ContactHeader("Overall Cultural Coordinator"));
        listItems.add(new ContactDetails("Aditya Durai", "+91 9566145762"));

        listItems.add(new ContactHeader("Media"));
        listItems.add(new ContactDetails("Nikilav. P. V.", "+91 9500140315"));
        listItems.add(new ContactDetails("Venkat", "+91 9488813070"));

        listItems.add(new ContactHeader("Thespian"));
        listItems.add(new ContactDetails("Anuraag Vikram Kate", "+91 9585912813"));
        listItems.add(new ContactDetails("Lakshminarayanan", "+91 8122146785"));

        listItems.add(new ContactHeader("English Lits"));
        listItems.add(new ContactDetails("Anirudh. C. S.", "+91 9940467937"));
        listItems.add(new ContactDetails("Arjun", "+91 9884010680"));

        listItems.add(new ContactHeader("Tamil Lits"));
        listItems.add(new ContactDetails("Nandha", "+91 8122486508"));
        listItems.add(new ContactDetails("Ramki", "+91 9003565966"));

        listItems.add(new ContactHeader("Hindi Lits"));
        listItems.add(new ContactDetails("Asif Ahmed", "+91 9003343773"));
        listItems.add(new ContactDetails("Amrita Kesari", "+91 9597886736"));

        listItems.add(new ContactHeader("Telugu Lits"));
        listItems.add(new ContactDetails("Bhuvana Mitra", "+91 7708073118"));
        listItems.add(new ContactDetails("Shivaprakash", "+91 8754627553"));

        listItems.add(new ContactHeader("Music"));
        listItems.add(new ContactDetails("Adhithya", "+91 9500482868"));
        listItems.add(new ContactDetails("Anirudh", "+91 9789819309"));

        listItems.add(new ContactHeader("Eastern Dance"));
        listItems.add(new ContactDetails("Swetha", "+91 9710926781"));

        listItems.add(new ContactHeader("Western Dance"));
        listItems.add(new ContactDetails("Sanjai Praboo", "+91 9894755668"));
        listItems.add(new ContactDetails("Adithya", "+91 9940032091"));

        listItems.add(new ContactHeader("Fine Arts"));
        listItems.add(new ContactDetails("Syed Ajmal", "+91 9790893730"));
        listItems.add(new ContactDetails("Vinushitha", "+91 9786066980"));

        listItems.add(new ContactHeader("Marketing"));
        listItems.add(new ContactDetails("Abhijith", "+91 9500165092"));
        listItems.add(new ContactDetails("Akash Shankar", "+91 9840925092"));

        listItems.add(new ContactHeader("Publicity"));
        listItems.add(new ContactDetails("Raja Kumaran", "+91 8056975409"));

        listItems.add(new ContactHeader("Public Relations"));
        listItems.add(new ContactDetails("Vishal", "+91 9677052091"));

        listItems.add(new ContactHeader("Hospitality"));
        listItems.add(new ContactDetails("Bhuvaneshwaran", "+91 9367623888"));

        listItems.add(new ContactHeader("Infrastructure"));
        listItems.add(new ContactDetails("Kissanth Tamilselvan", "+91 7200236463"));
        listItems.add(new ContactDetails("Ayush Krishnan", "+91 9629980718"));

        listItems.add(new ContactHeader("Crowd Control"));
        listItems.add(new ContactDetails("Deva Saravanan", "+91 9659047060"));
        listItems.add(new ContactDetails("Raghuraman Srinivasan", "+91 9094911674"));

        listItems.add(new ContactHeader("Merchandise"));
        listItems.add(new ContactDetails("Nitesh Sekar", "+91 9865786572"));
        listItems.add(new ContactDetails("Barani Dharan", "+91 9488255669"));

        listAdapter = new ContactsListAdapter(getActivity(), listItems);
        contactsListView.setAdapter(listAdapter);
        contactsListView.setOnItemClickListener(this);

        return contactView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
    {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_contact);
        LinearLayout callLayout = (LinearLayout)dialog.findViewById(R.id.call_layout);
        LinearLayout smsLayout = (LinearLayout)dialog.findViewById(R.id.sms_layout);

        final TextView contactNumber = (TextView)v.findViewById(R.id.contact_number);

        callLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+contactNumber.getText().toString()));
                getActivity().startActivity(intent);
            }
        });

        smsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"+contactNumber.getText().toString()));
                getActivity().startActivity(intent);
            }
        });

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        TextView callIcon = (TextView)dialog.findViewById(R.id.call_icon);
        TextView smsIcon = (TextView)dialog.findViewById(R.id.sms_icon);
        callIcon.setTypeface(typeface);
        smsIcon.setTypeface(typeface);
        dialog.show();
    }

}
