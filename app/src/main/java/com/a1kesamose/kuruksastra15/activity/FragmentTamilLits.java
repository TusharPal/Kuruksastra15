package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentTamilLits extends Fragment
{

    public static FragmentTamilLits newInstance()
    {
        FragmentTamilLits fragmentTamilLits = new FragmentTamilLits();

        return fragmentTamilLits;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_tamillits, container, false);
    }
}
