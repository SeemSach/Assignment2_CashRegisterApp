package com.example.assignment2_cashregisterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//Code Written By: Seema Shabadi 23/11/2022
public class ProductDetailsList_CustomAdapter extends BaseAdapter {
    //This is a class which is needed to bind the product details to our table
    ArrayList<ProductDetails> prod_list;
    Context context;

    public ProductDetailsList_CustomAdapter(ArrayList<ProductDetails> list, Context context) {
        this.prod_list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return prod_list.size();
    }
    @Override
    public Object getItem(int i) {
        return prod_list.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    //Each row is a view hence we are using customized row in which we have text fields and we need it to inflate
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.product_details_list_row,viewGroup,false);
        TextView productName = v.findViewById(R.id.product_name);
        TextView productQty = v.findViewById(R.id.product_qty);
        TextView productPrice = v.findViewById(R.id.product_price);
        productName.setText(prod_list.get(i).prod_name);
        productPrice.setText(String.valueOf(prod_list.get(i).prod_price));
        productQty.setText(String.valueOf(prod_list.get(i).prod_qty));
        return v;
    }
}
