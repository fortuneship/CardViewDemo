package com.tunex.cardviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hp on 10-Jun-17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    ArrayList<Contact> contacts = new ArrayList<Contact>();

    Context ctx;

    public ContactAdapter(ArrayList<Contact> contacts, Context ctx) {

       this.contacts = contacts;
        this.ctx = ctx;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent , false);

        ContactViewHolder contactViewHolder = new ContactViewHolder(view, ctx, contacts);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

        //Attach resources to view component

        Contact CON = contacts.get(position);
        holder.person_img.setImageResource(CON.getImage_id());
        holder.person_name.setText(CON.getName());
        holder.person_email.setText(CON.getEmail());
        holder.person_mobile.setText(CON.getMobile());



    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView person_img;
        TextView person_name, person_email, person_mobile;

        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Context ctx;

        public ContactViewHolder(View view, Context ctx, ArrayList<Contact> contacts) {

            super(view);

            this.contacts = contacts;
            this.ctx = ctx;

            //Restore the cardview for the onclick listener
            view.setOnClickListener(this);

            person_img = (ImageView) view.findViewById(R.id.person_image);
            person_name = (TextView) view.findViewById(R.id.person_name);
            person_email = (TextView) view.findViewById(R.id.person_email);
            person_mobile = (TextView) view.findViewById(R.id.person_mobile);

        }


        @Override
        public void onClick(View view) {

            //Start new activity and pass person image,name,email and number (i.e get the data from the array list)

            int position = getAdapterPosition();

            Contact contact = this.contacts.get(position);

            Intent intent = new Intent(this.ctx, ContactDetails.class);

            intent.putExtra("img_id", contact.getImage_id());
            intent.putExtra("name", contact.getName());
            intent.putExtra("email", contact.getEmail());
            intent.putExtra("mobile", contact.getMobile());

            this.ctx.startActivity(intent);

        }
    }
}
