package com.a1kesamose.kuruksastra15.listItemClasses;


import com.a1kesamose.kuruksastra15.itemInterface.ListItem;

/**
 * Created by Achyuth on 14-Mar-15.
 */
public class ContactDetails implements ListItem
{
    public final String name, phoneNumber;

    public ContactDetails(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isSectionHeader() {
        return false;
    }
}
