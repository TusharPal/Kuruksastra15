package com.a1kesamose.kuruksastra15.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.a1kesamose.kuruksastra15.R;

public class FragmentSchedule extends Fragment implements View.OnClickListener
{
    private static final String NAVIGATION_DRAWER_POSITION = "navigation_drawer_position";
    private Button button;

    public static FragmentSchedule newInstance(int navigationDrawerPosition)
    {
        Bundle args = new Bundle();
        args.putInt(NAVIGATION_DRAWER_POSITION, navigationDrawerPosition);

        FragmentSchedule fragment = new FragmentSchedule();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView=null;

        switch(getArguments().getInt(NAVIGATION_DRAWER_POSITION))
        {
            case 6:
            {
                rootView = inflater.inflate(R.layout.fragment_schedule_day_one, container, false);
                button = (Button)rootView.findViewById(R.id.button_legend_fragment_schedule_day_one);
                button.setOnClickListener(this);
                break;

//                return rootView;
            }
            case 7:
            {
                rootView = inflater.inflate(R.layout.fragment_schedule_day_one, container, false);
                button = (Button)rootView.findViewById(R.id.button_legend_fragment_schedule_day_one);
                button.setOnClickListener(this);
                break;
//                return rootView;
            }
            case 8:
            {
                rootView = inflater.inflate(R.layout.fragment_schedule_day_two, container, false);
                button = (Button)rootView.findViewById(R.id.button_legend_fragment_schedule_day_two);
                button.setOnClickListener(this);
                break;
//                return rootView;
            }
            case 9:
            {
                rootView = inflater.inflate(R.layout.fragment_schedule_day_three, container, false);
                button = (Button)rootView.findViewById(R.id.button_legend_fragment_schedule_day_three);
                button.setOnClickListener(this);
                break;
//                return rootView;
            }
        }

        return rootView;
//        return inflater.inflate(R.layout.fragment_schedule_day_one, container, false);
    }

    @Override
    public void onClick(View view)
    {
        createDialogLegend();
    }

    public void createDialogLegend()
    {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_legend);
        dialog.show();
    }
}
