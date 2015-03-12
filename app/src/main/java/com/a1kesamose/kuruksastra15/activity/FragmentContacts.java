package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.adapter.ContactsListAdapter;

public class FragmentContacts extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView contactLogoTextView;
    Typeface fontAwesomeTypeface;
    ContactsListAdapter listAdapter;
    ListView contactsListView;

    String[] contactHeaders = {"Overall Cultural Co-ordinator", "Media", "Thespian", "English Lits", "Tamil Lits", "Hindi Lits",
                                "Telugu Lits", "Eastern Dance", "Western Dance", "Music", "Fine Arts", "Marketing", "Hospitality", "Publicity",
                                "Public Relations", "Crowd Control", "Infrastructure", "Merchandise"};

    String[] contactNames = {"Aditya Durai", "Nikilav. P. V.", "Venkat", "Anuraag Vikram Kate", "Lakshminarayanan", "Anirudh. C. S.", "Arjun",
                            "Nandha", "Ramki", "Asif Ahmed", "Amrita Kesari", "Bhuvana Mitra", "Shivaprakash", "Swetha", "Sanjai Prabo", "Adithya",
                            "Adhithya", "Anirudh", "Syed Ajmal", "Vinushitha", "Abhijit", "Akash Shankar", "Bhuvaneshwaran", "Raja Kumaran", "Vishal", "Deva Saravanan", "Raghuraman Srinivasan",
                            "Kissanth Tamilselvan", "Ayush Krishnan", "Nitesh Sekar", "Barani Dharan"};

    String[] contactNumbers = {"+91 9566145762", "+91 9500140315", "+91 9488813070", "+91 9585912813", "+91 8122146785", "+91 9940467937", "+91 9884010680", "+91 8122486508", "+91 9003565966",
                                "+91 9003343773", "+91 9597886736", "+91 7708073118", "+91 8754627553", "+91 9710926781", "+91 9894755668", "+91 9940032091", "+91 9500482868", "+91 9789819309",
                                "+91 9790893730", "+91 9786066980", "+91 9500165092", "+91 9840925092", "+91 9367623888", "+91 8056975409", "+91 9677052091", "+91 9659047060", "+91 9094911674",
                                "+91 7200236463", "+91 9629980718", "+91 9865786572" , "+91 9488255669"};

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
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        contactLogoTextView = (TextView)rootView.findViewById(R.id.txt_contact_logo);
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        contactLogoTextView.setTypeface(fontAwesomeTypeface);
        contactsListView = (ListView)rootView.findViewById(R.id.contact_list_view);

        listAdapter = new ContactsListAdapter(getActivity(), contactHeaders, contactNames, contactNumbers);
        contactsListView.setAdapter(listAdapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ((ActivityMain)activity).onSectionAttached(getArguments().getInt(NAVIGATION_DRAWER_POSITION));
    }
}
