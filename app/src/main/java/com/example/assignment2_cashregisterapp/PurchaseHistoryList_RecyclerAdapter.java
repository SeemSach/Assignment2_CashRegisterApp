package com.example.assignment2_cashregisterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//Code Written By: Seema Shabadi 23/11/2022
//recycle view is where a roe or view holder is recycled instead of creating a new row
//We are using recycle adapter to bind our data to table.
//Recycler view has a view holder hence we need to implement the action listeners whene user interacts with the view holder
//Unlike base adapter we have to create our own actions listeners
public class PurchaseHistoryList_RecyclerAdapter extends
        RecyclerView.Adapter<PurchaseHistoryList_RecyclerAdapter.PurchaseHistoryList_ViewHolder> {
//declare action listener and leave it to user to implement all the protocols in it
    interface itemCallBackInterface{
        void onItemClicked(int pos);
    }

    ArrayList<PurchaseHistory> list;
    Context context;
    itemCallBackInterface listener;
    PurchaseHistoryList_RecyclerAdapter(ArrayList<PurchaseHistory> l, Context c){
        // step 1
        list = l;
        context = c;
    }

    @Override
    public PurchaseHistoryList_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // step 3
        View v = LayoutInflater.from(context).inflate(R.layout.purchase_history_details_list_row,parent, false);
        return new PurchaseHistoryList_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder( PurchaseHistoryList_ViewHolder holder, int position) {
        // step 5


        holder.productType_text.setText(list.get(position).prod_name);
        holder.productQty_text.setText(String.valueOf(list.get(position).prod_qty));
        holder.totalBill_text.setText(String.valueOf(list.get(position).prod_price));


    }

    @Override
    public int getItemCount() {
        // step 2
        return list.size();
    }
//This is an inner class needed to be declared inside the class recyclerAdapter which is our outer class here
    //This constructs our view holder which is actually a row for our recycler table
    class PurchaseHistoryList_ViewHolder extends RecyclerView.ViewHolder
    {
        TextView productType_text;
        TextView productQty_text;
        TextView totalBill_text;
        public PurchaseHistoryList_ViewHolder( View itemView) {
            // step 4
            super(itemView);
            productType_text =  itemView.findViewById(R.id.history_product_name);
            productQty_text = itemView.findViewById(R.id.history_product_qty);
            totalBill_text = itemView.findViewById(R.id.history_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // no idea when the user will click this item
                    listener.onItemClicked(getAdapterPosition());
                }
            });

        }
    }



}
