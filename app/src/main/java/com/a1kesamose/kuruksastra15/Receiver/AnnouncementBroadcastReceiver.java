package com.a1kesamose.kuruksastra15.Receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.a1kesamose.kuruksastra15.Database.AnnouncementsDatabaseSource;
import com.a1kesamose.kuruksastra15.Objects.Announcement;
import com.a1kesamose.kuruksastra15.R;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnnouncementBroadcastReceiver extends BroadcastReceiver
{
    public Context context;
    public AnnouncementsDatabaseSource databaseSource;
    public NotificationManager notificationManager;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        this.context = context;
        this.databaseSource = new AnnouncementsDatabaseSource(context);
        this.databaseSource.open();
        this.notificationManager = (NotificationManager)context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if(isNetworkAvailable())
        {
            HttpRequestTask httpCountRequestTask = new HttpRequestTask();
            httpCountRequestTask.execute("http://ksupdates.herokuapp.com/api/count");
        }
    }

    public boolean isNetworkAvailable()
    {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
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
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
        notificationBuilder.setContentTitle(announcement.ANNOUNCEMENT_CLUSTER);
        notificationBuilder.setContentText(announcement.ANNOUNCEMENT_CONTENT);
        notificationBuilder.setSmallIcon(R.drawable.ks_icon);
        notificationBuilder.setDefaults(Notification.DEFAULT_SOUND);
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        Notification  notification = notificationBuilder.build();
        notificationManager.notify(1010 * (flag+1), notification);
    }

    class HttpRequestTask extends AsyncTask<String, Void, String>
    {
        int announcementCount = 0;
        String URL_ANNOUNCEMENT = "http://ksupdates.herokuapp.com/api/announcements/";
        HttpAnnouncementRequest httpAnnouncementRequest = new HttpAnnouncementRequest();

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

        class HttpAnnouncementRequest extends AsyncTask<String, Void, String>
        {
            JSONArray announcementsJsonArray;
            public SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

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
                        if(preferences.getBoolean(announcement.ANNOUNCEMENT_CLUSTER,false))
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
