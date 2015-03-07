package com.a1kesamose.kuruksastra15.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a1kesamose.kuruksastra15.activity.FragmentFineArts;
import com.a1kesamose.kuruksastra15.activity.FragmentDance;
import com.a1kesamose.kuruksastra15.activity.FragmentEnglishLits;
import com.a1kesamose.kuruksastra15.activity.FragmentHindiLits;
import com.a1kesamose.kuruksastra15.activity.FragmentMedia;
import com.a1kesamose.kuruksastra15.activity.FragmentMusic;
import com.a1kesamose.kuruksastra15.activity.FragmentTamilLits;
import com.a1kesamose.kuruksastra15.activity.FragmentTeluguLits;
import com.a1kesamose.kuruksastra15.activity.FragmentThespian;

public class FragmentPagerAdapterEvents extends FragmentPagerAdapter
{
    private final int fragmentCount = 9;
    private final String[] eventsClusters = {"Media",
                                            "Thespian",
                                            "English Lits",
                                            "Hindi Lits",
                                            "Tamil Lits",
                                            "Telugu Lits",
                                            "Music",
                                            "Dance",
                                            "Fine Arts"};

    public FragmentPagerAdapterEvents(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
            {
                return FragmentMedia.newInstance();
            }
            case 1:
            {
                return FragmentThespian.newInstance();
            }
            case 2:
            {
                return FragmentEnglishLits.newInstance();
            }
            case 3:
            {
                return FragmentHindiLits.newInstance();
            }
            case 4:
            {
                return FragmentTamilLits.newInstance();
            }
            case 5:
            {
                return FragmentTeluguLits.newInstance();
            }
            case 6:
            {
                return FragmentMusic.newInstance();
            }
            case 7:
            {
                return FragmentDance.newInstance();
            }
            case 8:
            {
                return FragmentFineArts.newInstance();
            }
            default:
            {
                return FragmentMedia.newInstance();
            }
        }
    }

    @Override
    public int getCount()
    {
        return fragmentCount;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return eventsClusters[position];
    }
}
