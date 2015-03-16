package com.a1kesamose.kuruksastra15.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.a1kesamose.kuruksastra15.Database.AnnouncementsDatabaseSource;
import com.a1kesamose.kuruksastra15.Objects.Announcement;

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

    @Override
    public void onReceive(Context context, Intent intent)
    {
        this.context = context;
        this.databaseSource = new AnnouncementsDatabaseSource(context);
        this.databaseSource.open();

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

                return result;
            }

            @Override
            protected void onPostExecute(String result)
            {
                try
                {
                    JSONObject mainObject = new JSONObject(result);
                    announcementsJsonArray = mainObject.getJSONArray("details");

                    Log.d("----------------", "----------------");

                    for(int i=0; i<announcementsJsonArray.length(); i++)
                    {
                        JSONObject arrayJSONObject = announcementsJsonArray.getJSONObject(i);
                        Log.d("CLUSTER", arrayJSONObject.getString("cluster"));
                        Log.d("ANNOUNCEMENT", arrayJSONObject.getString("announcement"));
                        Log.d("TIME", arrayJSONObject.getString("time"));

                        Announcement announcement = new Announcement(arrayJSONObject.getString("cluster"), arrayJSONObject.getString("announcement"), arrayJSONObject.getString("time"));
                        databaseSource.insertAnnouncement(announcement);
                    }

                    Log.d("----------------", "----------------");

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
