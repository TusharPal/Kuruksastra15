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

        listAdapter = new ContactsListAdapter(getActivity());
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
