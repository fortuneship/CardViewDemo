package com.tunex.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Contact> list = new ArrayList<Contact>();

    int[] img_res = {R.drawable.antman, R.drawable.brooklyn,R.drawable.carol, R.drawable.creed, R.drawable.goosebumps,
            R.drawable.insideout, R.drawable.legend, R.drawable.spectra, R.drawable.spotlight};

    String[] name, email, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.person_email);
        email = getResources().getStringArray(R.array.person_email);
        mobile = getResources().getStringArray(R.array.person_number);

        int count = 0;

        for(String Name : name) {

            Contact contact = new Contact(img_res[count], Name, email[count], mobile[count]);

            count++;

            list.add(contact);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list, this);
        recyclerView.setAdapter(adapter);


    }
}
