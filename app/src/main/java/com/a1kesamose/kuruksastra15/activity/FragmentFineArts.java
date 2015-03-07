package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentFineArts extends Fragment
{
    public static FragmentFineArts newInstance()
    {
        FragmentFineArts fragmentFineArts = new FragmentFineArts();

        return fragmentFineArts;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_finearts, container, false);
    }
}