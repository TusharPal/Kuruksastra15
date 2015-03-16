package com.a1kesamose.kuruksastra15.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.Database.AnnouncementsDatabaseSource;
import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.adapter.AnnouncementListAdapter;

public class FragmentAnnouncements extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    private AnnouncementListAdapter listAdapter;
    private AnnouncementsDatabaseSource databaseSource;

    private ListView listViewAnnouncements;
    private TextView textViewIcon;
    private Typeface fontawesomeTypeface;

    public static FragmentAnnouncements newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentAnnouncements fragment = new FragmentAnnouncements();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        fontawesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        databaseSource = new AnnouncementsDatabaseSource(getActivity());
        databaseSource.open();
        listAdapter = new AnnouncementListAdapter(getActivity(), databaseSource.getAnnouncementList());

        View rootView = inflater.inflate(R.layout.fragment_announcements, container, false);
        listViewAnnouncements = (ListView)rootView.findViewById(R.id.listView_fragment_announcement);
        listViewAnnouncements.setAdapter(listAdapter);
        textViewIcon = (TextView)rootView.findViewById(R.id.textView_icon_fragment_announcements);
        textViewIcon.setTypeface(fontawesomeTypeface);

        return rootView;
    }
}


