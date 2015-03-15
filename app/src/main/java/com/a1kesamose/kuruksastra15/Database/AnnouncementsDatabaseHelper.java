package com.a1kesamose.kuruksastra15.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AnnouncementsDatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "announcements.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "announcements";

    public static final String COLUMN_CLUSTER = "cluster";
    public static final String COLUMN_ANNOUNCEMENT = "announcement";
    public static final String COLUMN_TIME = "time";

    private static final String CREATE_DATABASE = "CREATE TABLE " + TABLE_NAME + "("
                                                    + COLUMN_CLUSTER + " TEXT NOT NULL, "
                                                    + COLUMN_ANNOUNCEMENT + " TEXT NOT NULL, "
                                                    + COLUMN_TIME + " TEXT NOT NULL);";

    public AnnouncementsDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
