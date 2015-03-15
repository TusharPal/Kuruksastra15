package com.a1kesamose.kuruksastra15.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;

public class FragmentAnnouncements extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    ListView announcementListView;
    TextView announcementIcon;
    Typeface fontawesomeTypeface;

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
        View rootView = inflater.inflate(R.layout.fragment_announcements, container, false);

        fontawesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        announcementIcon = (TextView)rootView.findViewById(R.id.announcement_icon);
        announcementIcon.setTypeface(fontawesomeTypeface);
        return rootView;
    }
}


