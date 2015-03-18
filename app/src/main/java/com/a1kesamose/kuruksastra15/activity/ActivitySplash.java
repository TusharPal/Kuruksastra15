package com.a1kesamose.kuruksastra15.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.a1kesamose.kuruksastra15.R;

public class ActivitySplash extends ActionBarActivity {

    private static int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(ActivitySplash.this, ActivityMain.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIMEOUT);

    }
}
