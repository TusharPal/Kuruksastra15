package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1kesamose.kuruksastra15.R;


public class FragmentKSUphaar extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    Typeface fontAwesomeTypeface;
    TextView uphaarIconTextView;

    public static FragmentKSUphaar newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentKSUphaar fragment = new FragmentKSUphaar();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_ksuphaar, container, false);
        uphaarIconTextView = (TextView)rootView.findViewById(R.id.uphaar_logo);
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");

        uphaarIconTextView.setTypeface(fontAwesomeTypeface);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ((ActivityMain)activity).onSectionAttached(getArguments().getInt(NAVIGATION_DRAWER_POSITION));
    }
}
