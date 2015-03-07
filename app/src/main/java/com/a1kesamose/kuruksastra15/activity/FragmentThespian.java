package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentThespian extends Fragment
{
    public static FragmentThespian newInstance()
    {
        FragmentThespian fragmentThespian = new FragmentThespian();

        return fragmentThespian;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_thespian, container, false);
    }
}
