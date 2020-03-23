package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/* Item Adapter Class for adapting list items into layout */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    String[] items;
    String[] prices;
    String[] descriptions;

    //constructor for class, initialize members
    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //return amount of items in item list
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflate view
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        //get TextViews
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        //get string values for current item in list
        String name = items[position];
        String desc = descriptions[position];
        String cost = prices[position];
        //set text of textviews to string values
        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(cost);
        //return view, with 3 text views for name, desc, and cost
        return v;
    }
}
