package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentAnnouncements extends Fragment {

    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";

    public static FragmentAnnouncements newInstance(int navigationDrawerPosition) {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentAnnouncements fragment = new FragmentAnnouncements();
        fragment.setArguments(args);

        return fragment;
    }

    public FragmentAnnouncements() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_announcements, container, false);
    }


}
