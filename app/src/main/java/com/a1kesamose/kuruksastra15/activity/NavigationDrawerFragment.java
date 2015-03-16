package com.a1kesamose.kuruksastra15.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.adapter.NavigationDrawerListAdapter;

public class NavigationDrawerFragment extends Fragment
{
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private NavigationDrawerCallbacks mCallbacks;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mCurrentSelectedPosition = 0;
    private int easterEggClickCount = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
    private NavigationDrawerListAdapter navigationDrawerListAdapter;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private ImageView imageView;
    private View mFragmentContainerView;

    public NavigationDrawerFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if (savedInstanceState != null)
        {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        selectItem(mCurrentSelectedPosition);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        mDrawerListView = (ListView)rootView.findViewById(R.id.listView_fragment_navigation_drawer);
        imageView = (ImageView)rootView.findViewById(R.id.imageView_fragment_navigation_drawer);
        navigationDrawerListAdapter = new NavigationDrawerListAdapter(getActivity().getApplicationContext(), mCurrentSelectedPosition);
        mDrawerListView.setAdapter(navigationDrawerListAdapter);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                navigationDrawerListAdapter.setItemSelectedPosition(position);

                selectItem(position);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                switch(view.getId())
                {
                    case R.id.imageView_fragment_navigation_drawer:
                    {
                        if(easterEggClickCount == 6)
                        {
                            createEasterEggDialog();
                        }
                        else if(easterEggClickCount > 3)
                        {
                            Toast.makeText(getActivity(), easterEggClickCount + " clicks remaining", Toast.LENGTH_SHORT).show();
                            easterEggClickCount = (easterEggClickCount+1) %7;
                        }
                    }
                }
            }
        });

        return rootView;
    }

    public boolean isDrawerOpen()
    {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout)
    {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, R.drawable.ic_drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);

                if(!isAdded())
                {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);

                if(!isAdded())
                {
                    return;
                }

                if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
                }

                getActivity().supportInvalidateOptionsMenu();
            }
        };

        if(!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        mDrawerLayout.post(new Runnable()
        {
            @Override
            public void run()
            {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void selectItem(int position)
    {
        mCurrentSelectedPosition = position;

        if(mDrawerListView != null)
        {
            mDrawerListView.setItemChecked(position, true);
        }
        if(mDrawerLayout != null)
        {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if(mCallbacks != null)
        {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            mCallbacks = (NavigationDrawerCallbacks)activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();

        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        if(mDrawerLayout != null && isDrawerOpen())
        {
            inflater.inflate(R.menu.global, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showGlobalContextActionBar()
    {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setTitle(R.string.app_name);
    }

    private ActionBar getActionBar()
    {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

    public void createEasterEggDialog()
    {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_easter_egg);
        dialog.show();
    }

    public static interface NavigationDrawerCallbacks
    {
        void onNavigationDrawerItemSelected(int position);
    }
}
