package com.a1kesamose.kuruksastra15.listItemClasses;


import com.a1kesamose.kuruksastra15.itemInterface.ListItem;

/**
 * Created by Achyuth on 14-Mar-15.
 */
public class ContactHeader implements ListItem
{
    private final String header;

    public ContactHeader(String header)
    {
        this.header = header;
    }

    public String getHeader()
    {
        return header;
    }

    @Override
    public boolean isSectionHeader() {
        return true;
    }
}
