package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a1kesamose.kuruksastra15.R;

public class FragmentMedia extends Fragment
{
    public static FragmentMedia newInstance()
    {
        FragmentMedia fragmentMedia = new FragmentMedia();

        return fragmentMedia;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_media, container, false);
    }
}
