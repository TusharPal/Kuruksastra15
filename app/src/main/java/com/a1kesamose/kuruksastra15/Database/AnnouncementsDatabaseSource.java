package com.a1kesamose.kuruksastra15.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AnnouncementsDatabaseSource
{
    private AnnouncementsDatabaseHelper helper;
    private SQLiteDatabase database;

    public AnnouncementsDatabaseSource(Context context)
    {
        helper = new AnnouncementsDatabaseHelper(context, AnnouncementsDatabaseHelper.DATABASE_NAME, null, AnnouncementsDatabaseHelper.DATABASE_VERSION);
    }

    public void open()
    {
        database = helper.getWritableDatabase();
    }

    public void close()
    {
        database.close();
    }
}
