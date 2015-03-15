package com.a1kesamose.kuruksastra15.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.a1kesamose.kuruksastra15.Objects.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementsDatabaseSource
{
    private AnnouncementsDatabaseHelper helper;
    private SQLiteDatabase database;
    private String allColumns[] = {AnnouncementsDatabaseHelper.COLUMN_CLUSTER,
                                    AnnouncementsDatabaseHelper.COLUMN_ANNOUNCEMENT,
                                    AnnouncementsDatabaseHelper.COLUMN_TIME};

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

    public void insertAnnouncement(Announcement announcement)
    {
        ContentValues values = new ContentValues();
        values.put(AnnouncementsDatabaseHelper.COLUMN_CLUSTER, announcement.ANNOUNCEMENT_CLUSTER);
        values.put(AnnouncementsDatabaseHelper.COLUMN_ANNOUNCEMENT, announcement.ANNOUNCEMENT_CONTENT);
        values.put(AnnouncementsDatabaseHelper.COLUMN_TIME, announcement.ANNOUNCEMENT_TIME);

        database.insert(AnnouncementsDatabaseHelper.TABLE_NAME, null, values);
    }

    public List<Announcement> getAnnouncementList()
    {
        Cursor cursor = database.query(AnnouncementsDatabaseHelper.TABLE_NAME, allColumns, null, null, null, null, AnnouncementsDatabaseHelper.COLUMN_TIME + " DESC", null);
        List<Announcement> list = new ArrayList<Announcement>();

        if(cursor.moveToFirst())
        {
            while(!cursor.isAfterLast())
            {
                list.add(cursorToAnnouncement(cursor));
                cursor.moveToNext();
            }
            cursor.close();

            return list;
        }
        else
        {
            return list;
        }
    }

    public Announcement cursorToAnnouncement(Cursor cursor)
    {
        Announcement announcement = new Announcement();
        announcement.ANNOUNCEMENT_CLUSTER = cursor.getString(0);
        announcement.ANNOUNCEMENT_CONTENT = cursor.getString(1);
        announcement.ANNOUNCEMENT_TIME = cursor.getString(2);

        return announcement;
    }
}
