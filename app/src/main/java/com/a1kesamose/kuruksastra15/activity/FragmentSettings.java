package com.a1kesamose.kuruksastra15.activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.a1kesamose.kuruksastra15.R;



public class FragmentSettings extends Fragment
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView settingsIcon;
    Typeface fontAwesomeTypeface;
    SharedPreferences sharedPreferences;
    CheckBox mediaCheckBox, thespianCheckBox, elitsCheckBox, hlitsCheckBox, tlitsCheckBox, telitsCheckBox, eDanceCheckBox, wDanceCheckBox, musicCheckBox, artsCheckBox, generalCheckBox;


    public static FragmentSettings newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentSettings fragment = new FragmentSettings();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        fontAwesomeTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/fontawesome-webfont.ttf");

        settingsIcon = (TextView)rootView.findViewById(R.id.settings_icon);
        settingsIcon.setTypeface(fontAwesomeTypeface);

        mediaCheckBox = (CheckBox)rootView.findViewById(R.id.media_checkbox);
        final boolean mediaChecked = sharedPreferences.getBoolean("MEDIA", false);
        mediaCheckBox.setChecked(mediaChecked);
        mediaCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("MEDIA",isChecked).apply();
                mediaCheckBox.setChecked(isChecked);
            }
        });

        thespianCheckBox = (CheckBox)rootView.findViewById(R.id.thespian_checkbox);
        final boolean thespianChecked = sharedPreferences.getBoolean("THESPIAN", false);
        thespianCheckBox.setChecked(thespianChecked);
        thespianCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("THESPIAN",isChecked).apply();
                thespianCheckBox.setChecked(isChecked);
            }
        });

        elitsCheckBox = (CheckBox)rootView.findViewById(R.id.elits_checkbox);
        final boolean elitsChecked = sharedPreferences.getBoolean("ENGLISH LITS", false);
        elitsCheckBox.setChecked(elitsChecked);
        elitsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("ENGLISH LITS",isChecked).apply();
                elitsCheckBox.setChecked(isChecked);
            }
        });

        hlitsCheckBox = (CheckBox)rootView.findViewById(R.id.hlits_checkbox);
        final boolean hlitsChecked = sharedPreferences.getBoolean("HINDI LITS", false);
        hlitsCheckBox.setChecked(hlitsChecked);
        hlitsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("HINDI LITS",isChecked).apply();
                hlitsCheckBox.setChecked(isChecked);
            }
        });

        tlitsCheckBox = (CheckBox)rootView.findViewById(R.id.tlits_checkbox);
        final boolean tlitsChecked = sharedPreferences.getBoolean("TAMIL LITS", false);
        tlitsCheckBox.setChecked(tlitsChecked);
        tlitsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("TAMIL LITS",isChecked).apply();
                tlitsCheckBox.setChecked(isChecked);
            }
        });

        telitsCheckBox = (CheckBox)rootView.findViewById(R.id.telits_checkbox);
        final boolean telitsChecked = sharedPreferences.getBoolean("TELUGU LITS", false);
        telitsCheckBox.setChecked(telitsChecked);
        telitsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("TELUGU LITS",isChecked).apply();
                telitsCheckBox.setChecked(isChecked);
            }
        });

        eDanceCheckBox = (CheckBox)rootView.findViewById(R.id.east_dance_checkbox);
        final boolean eDanceChecked = sharedPreferences.getBoolean("EASTERN DANCE", false);
        eDanceCheckBox.setChecked(eDanceChecked);
        eDanceCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("EASTERN DANCE",isChecked).apply();
                eDanceCheckBox.setChecked(isChecked);
            }
        });

        wDanceCheckBox = (CheckBox)rootView.findViewById(R.id.west_dance_checkbox);
        final boolean wDanceChecked = sharedPreferences.getBoolean("WESTERN DANCE", false);
        wDanceCheckBox.setChecked(wDanceChecked);
        wDanceCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("WESTERN DANCE",isChecked).apply();
                wDanceCheckBox.setChecked(isChecked);
            }
        });

        musicCheckBox = (CheckBox)rootView.findViewById(R.id.music_checkbox);
        final boolean musicChecked = sharedPreferences.getBoolean("MUSIC", false);
        musicCheckBox.setChecked(musicChecked);
        musicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("MUSIC",isChecked).apply();
                musicCheckBox.setChecked(isChecked);
            }
        });

        artsCheckBox = (CheckBox)rootView.findViewById(R.id.arts_checkbox);
        final boolean artsChecked = sharedPreferences.getBoolean("ARTS", false);
        artsCheckBox.setChecked(artsChecked);
        artsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("ARTS",isChecked).apply();
                artsCheckBox.setChecked(isChecked);
            }
        });

        generalCheckBox = (CheckBox)rootView.findViewById(R.id.general_checkbox);
        final boolean generalChecked = sharedPreferences.getBoolean("UPDATE", false);
        generalCheckBox.setChecked(generalChecked);
        generalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences.edit().putBoolean("UPDATE",isChecked).apply();
                generalCheckBox.setChecked(isChecked);
            }
        });
        return rootView;
    }
}
