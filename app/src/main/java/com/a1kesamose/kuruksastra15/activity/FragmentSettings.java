package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;



public class FragmentSettings extends Fragment
{


    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView settingsIcon;
    Typeface fontAwesomeTypeface;


    public static FragmentSettings newInstance(int navigationDrawerPosition) {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentSettings fragment = new FragmentSettings();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");

        settingsIcon = (TextView)rootView.findViewById(R.id.settings_icon);
        settingsIcon.setTypeface(fontAwesomeTypeface);

        return rootView;
    }
}
