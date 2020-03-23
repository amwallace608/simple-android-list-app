package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //field variable for reference to list view from layout file
    ListView myListView;
    //references for string arrays
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create reference to resources
        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        //get string arrays for items, prices, and descriptions
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        //adapter to merge three items with layout file
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        //Create OnItemClickListener for list
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create intent to show Detail activity/screen
                Intent showDetailActivity =
                        new Intent(getApplicationContext(), DetailActivity.class);
                //pass item index to next screen to show correct item details
                showDetailActivity.putExtra("com.example.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });


    }
}
