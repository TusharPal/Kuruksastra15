package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.a1kesamose.kuruksastra15.R;

public class FragmentHome extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    ImageSwitcher homeScreenSlideShow;
    private static final int[] imageSources = {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4,
                                                R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8,
                                                R.drawable.i9, R.drawable.i10, R.drawable.i11, R.drawable.i12,
                                                R.drawable.i13, R.drawable.i14, R.drawable.i15, R.drawable.i16,
                                                R.drawable.i17, R.drawable.i18, R.drawable.i19, R.drawable.i20,
                                                R.drawable.i21, R.drawable.i22, R.drawable.i23, R.drawable.i24,
                                                R.drawable.i25, R.drawable.i26, R.drawable.i27, R.drawable.i28,
                                                R.drawable.i29, R.drawable.i30};

    public static FragmentHome newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        homeScreenSlideShow = (ImageSwitcher)rootView.findViewById(R.id.home_page_slideshow);
        homeScreenSlideShow.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity());
                return imageView;
            }
        });
        homeScreenSlideShow.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.abc_fade_in));
        homeScreenSlideShow.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.abc_fade_out));
        homeScreenSlideShow.postDelayed(new Runnable() {
            int position = 0;
            @Override
            public void run() {
                homeScreenSlideShow.setImageResource(imageSources[position]);
                position = (position+1)%imageSources.length;
                homeScreenSlideShow.postDelayed(this, 3000);
            }
        }, 3000);
        return rootView;
    }



    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ((ActivityMain)activity).onSectionAttached(getArguments().getInt(NAVIGATION_DRAWER_POSITION));
    }
}
