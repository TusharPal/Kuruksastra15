package com.a1kesamose.kuruksastra15.activity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.a1kesamose.kuruksastra15.Database.AnnouncementsDatabaseSource;
import com.a1kesamose.kuruksastra15.Objects.Announcement;
import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.Receiver.AnnouncementBroadcastReceiver;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;


public class ActivityMain extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;
    private Calendar calendar;
    private SharedPreferences sharedPreferences;
    public AnnouncementsDatabaseSource databaseSource;
    public NotificationManager notificationManager;
    public HttpCountRequestTask httpCountRequestTask;
    private String navigationDrawerItemTitles[] = {"About KS", "Events", "Announcements", "KS Upahaar", "Sponsors", "Contacts", "Schedule", "Day 1", "Day 2", "Day 3", "Settings"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
        mTitle = getTitle();
        notificationManager = (NotificationManager)this.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        databaseSource = new AnnouncementsDatabaseSource(this);
        databaseSource.open();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        httpCountRequestTask = new HttpCountRequestTask();

        if(!sharedPreferences.getBoolean("first_launch", false))
        {
            sharedPreferences.edit().putBoolean("UPDATE", true).apply();

            calendar = Calendar.getInstance();
            Intent notificationFetchIntent = new Intent(this, AnnouncementBroadcastReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1010 , notificationFetchIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 300000, pendingIntent);

            sharedPreferences.edit().putBoolean("first_launch", true).apply();
        }

        if(isNetworkAvailable())
        {
            httpCountRequestTask.execute("http://ksupdates.herokuapp.com/api/count");
        }
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
                fragmentManager.beginTransaction().replace(R.id.container, FragmentAnnouncements.newInstance(position)).commit();

                break;
            }
            case 3:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentProShows.newInstance(position)).commit();

                break;
            }
            case 4:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentKSUphaar.newInstance(position)).commit();

                break;
            }
            case 5:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSeniors.newInstance(position)).commit();

                break;
            }
            case 6:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSponsors.newInstance(position)).commit();

                break;
            }
            case 7:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentContacts.newInstance(position)).commit();

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
            case 10:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }
            case 11:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSchedule.newInstance(position)).commit();

                break;
            }

            case 12:
            {
                fragmentManager.beginTransaction().replace(R.id.container, FragmentSettings.newInstance(position)).commit();

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
        actionBar.setTitle("Kuruksastra'15");
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

    public boolean isNetworkAvailable()
    {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void createNotification(Announcement announcement, int flag)
    {

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle(announcement.ANNOUNCEMENT_CLUSTER);
        notificationBuilder.setContentText(announcement.ANNOUNCEMENT_CONTENT);
        notificationBuilder.setSmallIcon(R.drawable.ks_icon);
        notificationBuilder.setDefaults(Notification.DEFAULT_SOUND);
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        Notification  notification = notificationBuilder.build();
        notificationManager.notify(1010 * (flag+1), notification);
    }

    private class HttpCountRequestTask extends AsyncTask<String, Void, String>
    {
        int announcementCount = 0;
        String URL_ANNOUNCEMENT = "http://ksupdates.herokuapp.com/api/announcements/";
        HttpAnnouncementRequestTask httpAnnouncementRequest = new HttpAnnouncementRequestTask();

        @Override
        protected String doInBackground(String... url)
        {
            String result = "";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGetRequest = new HttpGet(url[0]);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            try
            {
                result = httpClient.execute(httpGetRequest, responseHandler);
            }
            catch(Exception e)
            {
                e.getStackTrace();
            }

            httpClient.getConnectionManager().shutdown();

            return result;
        }

        @Override
        protected void onPostExecute(String result)
        {
            JSONObject jsonObject;

            try
            {
                jsonObject = new JSONObject(result);
                announcementCount = jsonObject.getInt("count");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            if(databaseSource.getCount() != announcementCount)
            {
                int remainingAnnouncementsCount = announcementCount - databaseSource.getCount();
                httpAnnouncementRequest.execute(URL_ANNOUNCEMENT + remainingAnnouncementsCount);
            }
            else
            {
                databaseSource.close();
            }
        }

        private class HttpAnnouncementRequestTask extends AsyncTask<String, Void, String>
        {
            JSONArray announcementsJsonArray;

            @Override
            protected String doInBackground(String... url)
            {
                String result="";
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGetRequest = new HttpGet(url[0]);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();

                try
                {
                    result = httpClient.execute(httpGetRequest, responseHandler);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                httpClient.getConnectionManager().shutdown();
                return result;
            }

            @Override
            protected void onPostExecute(String result)
            {
                try
                {
                    JSONObject mainObject = new JSONObject(result);
                    announcementsJsonArray = mainObject.getJSONArray("details");

                    for(int i=0; i<announcementsJsonArray.length(); i++)
                    {
                        JSONObject arrayJSONObject = announcementsJsonArray.getJSONObject(i);
                        String announcementTime = arrayJSONObject.getString("time");
                        announcementTime = announcementTime.substring(0, announcementTime.length()-3);
                        Announcement announcement = new Announcement(arrayJSONObject.getString("cluster"), arrayJSONObject.getString("announcement"), announcementTime);
                        databaseSource.insertAnnouncement(announcement);
                        if(sharedPreferences.getBoolean(announcement.ANNOUNCEMENT_CLUSTER, false))
                        {
                            createNotification(announcement, i);
                        }
                    }

                    databaseSource.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
