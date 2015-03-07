package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentEnglishLits extends Fragment
{
    public static FragmentEnglishLits newInstance()
    {
        FragmentEnglishLits fragmentEnglishLits = new FragmentEnglishLits();

        return fragmentEnglishLits;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_englishlits, container, false);
    }
}
