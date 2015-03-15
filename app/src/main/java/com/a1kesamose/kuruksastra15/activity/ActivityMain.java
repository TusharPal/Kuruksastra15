package com.a1kesamose.kuruksastra15.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.a1kesamose.kuruksastra15.R;


public class ActivityMain extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private String navigationDrawerItemTitles[] = {"About KS", "Events", "Announcements", "KS Upahaar", "Sponsors", "Contacts", "Schedule", "Schedule", "Schedule", "Schedule"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
        mTitle = getTitle();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch(position)
        {
            case 0:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentHome.newInstance(position)).commit();

                break;
            }
            case 1:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentEvents.newInstance(position)).commit();

                break;
            }
            case 2:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentProShows.newInstance(position)).commit();

                break;
            }
            case 3:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentKSUphaar.newInstance(position)).commit();

                break;
            }
            case 4:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSponsors.newInstance(position)).commit();

                break;
            }
            case 5:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentContacts.newInstance(position)).commit();

                break;
            }
            case 6:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }
            case 7:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }
            case 8:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }
            case 9:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }
        }
    }

    public void onSectionAttached(int position)
    {
        mTitle = navigationDrawerItemTitles[position];
    }

    public void restoreActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        if(!mNavigationDrawerFragment.isDrawerOpen())
        {
            getMenuInflater().inflate(R.menu.activity_main, menu);
            restoreActionBar();

            return true;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_settings:
            {
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
