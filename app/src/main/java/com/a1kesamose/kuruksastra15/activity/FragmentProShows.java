package com.a1kesamose.kuruksastra15.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;


public class FragmentProShows extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView proShowsTextView;
    Typeface fontAwesomeTypeface;

    public static FragmentProShows newInstance(int navigationDrawerPosition)
    {
        FragmentProShows fragment = new FragmentProShows();
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        fragment.setArguments(args);
        return fragment;
    }

    public FragmentProShows() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_pro_shows, container, false);
        proShowsTextView = (TextView)rootView.findViewById(R.id.proshows_icon);
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        proShowsTextView.setTypeface(fontAwesomeTypeface);
        return rootView;
    }



}
