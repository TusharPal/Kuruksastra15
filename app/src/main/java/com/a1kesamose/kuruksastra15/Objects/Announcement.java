package com.a1kesamose.kuruksastra15.Objects;

public class Announcement
{
    public String ANNOUNCEMENT_CONTENT;
    public String ANNOUNCEMENT_CLUSTER;
    public String ANNOUNCEMENT_TIME;

    public Announcement(String ANNOUNCEMENT_CONTENT, String ANNOUNCEMENT_CLUSTER, String ANNOUNCEMENT_TIME)
    {
        this.ANNOUNCEMENT_CONTENT = ANNOUNCEMENT_CONTENT;
        this.ANNOUNCEMENT_CLUSTER = ANNOUNCEMENT_CLUSTER;
        this.ANNOUNCEMENT_TIME = ANNOUNCEMENT_TIME;
    }

    public Announcement()
    {
        this.ANNOUNCEMENT_CONTENT = "";
        this.ANNOUNCEMENT_CONTENT = "";
        this.ANNOUNCEMENT_TIME = "";
    }
}
