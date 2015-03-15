package com.a1kesamose.kuruksastra15.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a1kesamose.kuruksastra15.R;
import com.a1kesamose.kuruksastra15.activity.FragmentContacts;
import com.a1kesamose.kuruksastra15.itemInterface.ListItem;
import com.a1kesamose.kuruksastra15.listItemClasses.ContactDetails;
import com.a1kesamose.kuruksastra15.listItemClasses.ContactHeader;
import java.util.ArrayList;

/**
 * Created by Achyuth on 11-Mar-15.
 */
public class ContactsListAdapter extends ArrayAdapter<ListItem>
{
    Context context;
    ArrayList<ListItem> contactItems;
    private LayoutInflater layoutInflater;
    TextView callIcon, smsIcon;
    TextView contactName, contactNumber;


    public ContactsListAdapter(Context context, ArrayList<ListItem> contactItems)
    {
        super(context, 0, contactItems);
        this.context = context;
        this.contactItems = contactItems;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View contactView = convertView;

        final ListItem item = contactItems.get(position);
        if(item!=null)
        {
            if(item.isSectionHeader())
            {
                ContactHeader header = (ContactHeader)item;
                contactView = layoutInflater.inflate(R.layout.list_item_contact_seperator, null);
                contactView.setOnClickListener(null);
                contactView.setOnLongClickListener(null);
                contactView.setLongClickable(false);
                final TextView section = (TextView)contactView.findViewById(R.id.contact_section);
                section.setText(header.getHeader());
            }
            else
            {
                final ContactDetails contactDetails = (ContactDetails)item;
                contactView = layoutInflater.inflate(R.layout.list_item_contact, null);
                LinearLayout contactsLayout = (LinearLayout)contactView.findViewById(R.id.contact_details);
                contactName = (TextView)contactView.findViewById(R.id.contact_name);
                contactNumber = (TextView)contactView.findViewById(R.id.contact_number);
                if(contactName!=null)
                {
                    contactName.setText(contactDetails.name);
                }

                if(contactNumber!=null)
                {
                    contactNumber.setText(contactDetails.phoneNumber);
                }
            }
        }
        return contactView;
    }
}