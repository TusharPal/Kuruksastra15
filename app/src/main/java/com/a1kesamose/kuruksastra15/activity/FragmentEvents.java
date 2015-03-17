package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.adapter.FragmentPagerAdapterEvents;

public class FragmentEvents extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";

    private ViewPager viewPager;

    public static FragmentEvents newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentEvents fragment = new FragmentEvents();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        viewPager = (ViewPager)rootView.findViewById(R.id.viewPager_fragment_events);
        viewPager.setAdapter(new FragmentPagerAdapterEvents(getActivity().getSupportFragmentManager()));

        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ((ActivityMain)activity).onSectionAttached(getArguments().getInt(NAVIGATION_DRAWER_POSITION));
    }
}
