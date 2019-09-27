package com.list.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mylistView;
    String[] items;
    String[] prices;
    String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources rs=getResources();
        mylistView=findViewById(R.id.mylistView);
        items = rs.getStringArray(R.array.items);
        prices = rs.getStringArray(R.array.prices);
        descriptions = rs.getStringArray(R.array.descriptions);


        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        mylistView.setAdapter(itemAdapter);


        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id)
            {

                Intent showDetailActivity=new Intent(getApplicationContext(),DetailActivity.class);

                showDetailActivity.putExtra("butterfield.mentorschools.org.ITEM_INDEX",i);
                startActivity(showDetailActivity);

            }
        });
    }
}

