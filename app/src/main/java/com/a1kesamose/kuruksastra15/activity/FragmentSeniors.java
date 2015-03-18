package com.a1kesamose.kuruksastra15.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;

public class FragmentSeniors extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView seniorsIcon;
    Typeface fontAwesomeTypeface;

    public static FragmentSeniors newInstance(int navigationDrawerPosition) {
        FragmentSeniors fragment = new FragmentSeniors();
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_seniors, container, false);
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");
        seniorsIcon = (TextView)rootView.findViewById(R.id.seniors_icon);
        seniorsIcon.setTypeface(fontAwesomeTypeface);
        return rootView;
    }


}
