package com.tunex.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    ImageView imageView;
    TextView tx_name, tx_email, tx_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_datails_layout);

        imageView = (ImageView) findViewById(R.id.contact_image);
        tx_name = (TextView) findViewById(R.id.contact_name);
        tx_email = (TextView) findViewById(R.id.contact_email);
        tx_mobile = (TextView) findViewById(R.id.contact_mobile);

        imageView.setImageResource(getIntent().getIntExtra("img_id", 00));
        tx_name.setText("Name : " + getIntent().getStringExtra("name"));
        tx_email.setText("Email : " + getIntent().getStringExtra("email"));
        tx_name.setText("Mobile : " + getIntent().getStringExtra("mobile"));
    }
}
