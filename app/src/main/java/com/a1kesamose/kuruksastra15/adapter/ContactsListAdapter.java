package com.a1kesamose.kuruksastra15.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a1kesamose.kuruksastra15.R;
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
    TextView callIcon, smsIcon, saveIcon;



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
                TextView contactName = (TextView)contactView.findViewById(R.id.contact_name);
                TextView contactNumber = (TextView)contactView.findViewById(R.id.contact_number);
                if(contactName!=null)
                {
                    contactName.setText(contactDetails.name);
                }

                if(contactNumber!=null)
                {
                    contactNumber.setText(contactDetails.phoneNumber);
                }

                contactsLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        AlertDialog.Builder callDialogBuilder = new AlertDialog.Builder(getContext());
//                        LayoutInflater inflater = LayoutInflater.from(context);
//                        View view = inflater.inflate(R.layout.dialog_contact, null);
//                        callDialogBuilder.setView(view);
//                        AlertDialog contactDialog = callDialogBuilder.create();
//                        callIcon = (TextView)contactDialog.findViewById(R.id.call_icon);
//                        smsIcon = (TextView)contactDialog.findViewById(R.id.sms_icon);
//                        saveIcon = (TextView)contactDialog.findViewById(R.id.save_icon);
//
//                        Typeface fontAwesomeTypeface = Typeface.createFromAsset(contactDialog.getContext().getAssets(),"fonts/fontawesome-webfont.ttf");
//
//                        callIcon.setTypeface(fontAwesomeTypeface);
//                        smsIcon.setTypeface(fontAwesomeTypeface);
//                        saveIcon.setTypeface(fontAwesomeTypeface);
//                        contactDialog.show();

                    }
                });
            }
        }
        return contactView;
    }
}