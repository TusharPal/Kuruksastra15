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


public class FragmentSettings extends Fragment implements CompoundButton.OnCheckedChangeListener
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    TextView settingsIcon;
    Typeface fontAwesomeTypeface;
    SharedPreferences sharedPreferences;
    CheckBox checkBoxMedia, checkBoxThespian, checkBoxEnglishLits, checkBoxHindiLits, checkBoxTamilLits, checkBoxTeleguLits, checkBoxEasternDance, checkBoxWesternDance, checkBoxMusic, checkBoxArts, checkBoxGeneral;

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

        checkBoxMedia = (CheckBox)rootView.findViewById(R.id.media_checkbox);
        checkBoxThespian = (CheckBox)rootView.findViewById(R.id.thespian_checkbox);
        checkBoxEnglishLits = (CheckBox)rootView.findViewById(R.id.elits_checkbox);
        checkBoxHindiLits = (CheckBox)rootView.findViewById(R.id.hlits_checkbox);
        checkBoxTamilLits = (CheckBox)rootView.findViewById(R.id.tlits_checkbox);
        checkBoxTeleguLits = (CheckBox)rootView.findViewById(R.id.telits_checkbox);
        checkBoxEasternDance = (CheckBox)rootView.findViewById(R.id.east_dance_checkbox);
        checkBoxWesternDance = (CheckBox)rootView.findViewById(R.id.west_dance_checkbox);
        checkBoxMusic = (CheckBox)rootView.findViewById(R.id.music_checkbox);
        checkBoxArts = (CheckBox)rootView.findViewById(R.id.arts_checkbox);
        checkBoxGeneral = (CheckBox)rootView.findViewById(R.id.general_checkbox);

        checkBoxMedia.setChecked(sharedPreferences.getBoolean("MEDIA", false));
        checkBoxThespian.setChecked(sharedPreferences.getBoolean("THESPIAN", false));
        checkBoxEnglishLits.setChecked(sharedPreferences.getBoolean("ENGLISH LITS", false));
        checkBoxHindiLits.setChecked(sharedPreferences.getBoolean("HINDI LITS", false));
        checkBoxTamilLits.setChecked(sharedPreferences.getBoolean("TAMIL LITS", false));
        checkBoxTeleguLits.setChecked(sharedPreferences.getBoolean("TELUGU LITS", false));
        checkBoxEasternDance.setChecked(sharedPreferences.getBoolean("EASTERN DANCE", false));
        checkBoxWesternDance.setChecked(sharedPreferences.getBoolean("WESTERN DANCE", false));
        checkBoxMusic.setChecked(sharedPreferences.getBoolean("MUSIC", false));
        checkBoxArts.setChecked(sharedPreferences.getBoolean("ARTS", false));
        checkBoxGeneral.setChecked(sharedPreferences.getBoolean("UPDATE", false));

        checkBoxMedia.setOnCheckedChangeListener(this);
        checkBoxThespian.setOnCheckedChangeListener(this);
        checkBoxEnglishLits.setOnCheckedChangeListener(this);
        checkBoxHindiLits.setOnCheckedChangeListener(this);
        checkBoxTamilLits.setOnCheckedChangeListener(this);
        checkBoxTeleguLits.setOnCheckedChangeListener(this);
        checkBoxEasternDance.setOnCheckedChangeListener(this);
        checkBoxWesternDance.setOnCheckedChangeListener(this);
        checkBoxMusic.setOnCheckedChangeListener(this);
        checkBoxArts.setOnCheckedChangeListener(this);
        checkBoxGeneral.setOnCheckedChangeListener(this);

        return rootView;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean buttonState)
    {
        switch(compoundButton.getId())
        {
            case R.id.media_checkbox:
            {
                sharedPreferences.edit().putBoolean("MEDIA", buttonState).apply();
                checkBoxMedia.setChecked(buttonState);

                break;
            }
            case R.id.thespian_checkbox:
            {
                sharedPreferences.edit().putBoolean("THESPIAN", buttonState).apply();
                checkBoxThespian.setChecked(buttonState);

                break;
            }
            case R.id.elits_checkbox:
            {
                sharedPreferences.edit().putBoolean("ENGLISH LITS", buttonState).apply();
                checkBoxEnglishLits.setChecked(buttonState);

                break;
            }
            case R.id.hlits_checkbox:
            {
                sharedPreferences.edit().putBoolean("HINDI LITS", buttonState).apply();
                checkBoxHindiLits.setChecked(buttonState);

                break;
            }
            case R.id.tlits_checkbox:
            {
                sharedPreferences.edit().putBoolean("TAMIL LITS", buttonState).apply();
                checkBoxTamilLits.setChecked(buttonState);

                break;
            }
            case R.id.telits_checkbox:
            {
                sharedPreferences.edit().putBoolean("TELUGU LITS", buttonState).apply();
                checkBoxTeleguLits.setChecked(buttonState);

                break;
            }
            case R.id.east_dance_checkbox:
            {
                sharedPreferences.edit().putBoolean("EASTERN DANCE", buttonState).apply();
                checkBoxEasternDance.setChecked(buttonState);

                break;
            }
            case R.id.west_dance_checkbox:
            {
                sharedPreferences.edit().putBoolean("WESTERN DANCE", buttonState).apply();
                checkBoxWesternDance.setChecked(buttonState);

                break;
            }
            case R.id.music_checkbox:
            {
                sharedPreferences.edit().putBoolean("MUSIC", buttonState).apply();
                checkBoxMusic.setChecked(buttonState);

                break;
            }
            case R.id.arts_checkbox:
            {
                sharedPreferences.edit().putBoolean("ARTS", buttonState).apply();
                checkBoxArts.setChecked(buttonState);

                break;
            }
            case R.id.general_checkbox:
            {
                sharedPreferences.edit().putBoolean("UPDATE", buttonState).apply();
                checkBoxGeneral.setChecked(buttonState);

                break;
            }
        }
    }
}
