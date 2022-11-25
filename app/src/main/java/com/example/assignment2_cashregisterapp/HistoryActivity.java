package com.example.assignment2_cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
//Code Written By: Seema Shabadi 23/11/2022
public class HistoryActivity extends AppCompatActivity implements PurchaseHistoryList_RecyclerAdapter.itemCallBackInterface {
//This class has to implement all the methods that are necessary to action events that should take place whenever row is clicked
// that is view in view holder is clicked. It is an event listener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Purchase History");
        //We are using recycler view to hold all the purchase transactions history in a table
        RecyclerView purchase_history_recyclerView = findViewById(R.id.purchase_history_RecyclerList);

        PurchaseHistoryList_RecyclerAdapter adapter = new PurchaseHistoryList_RecyclerAdapter(
                ((MyApp)getApplication()).myStore.getPurchaseHistoryList(),
                this);
        adapter.listener = this;
        purchase_history_recyclerView.setAdapter(adapter);
        //layout manager is essential for linear representation of all the views in a row
        purchase_history_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // show a toast when one row clicked
        purchase_history_recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoryActivity.this,"Table clicked",Toast.LENGTH_SHORT).show();
            }
        });
       //We need to implement all the gestures that is touch events, swipe events on the row. Following is listener for all these events
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(HistoryActivity.this, "Entry Deleted ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                //Each time whenever is data deleted from recycler table which is our history table here; we need to update the list
                //as well as display of data in our table by following code
                ((MyApp)getApplication()).myStore.getPurchaseHistoryList().remove(position);
                adapter.notifyDataSetChanged();

            }
        };
//We need to attach the user interaction to the rows of recylcerView list table
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(purchase_history_recyclerView);

    }
//When an item is clicked that is a row is clicked it should start the next activity by passing the message
    @Override
    public void onItemClicked(int pos) {
        PurchaseHistory p_hist =  ((MyApp)getApplication()).myStore.getPurchaseHistoryList().get(pos);
        Intent toDetailedPurchaseHistoryIntent = new Intent(HistoryActivity.this,DetailedPurchaseHistory.class);
        History history = new History(p_hist.prod_name,p_hist.prod_qty,p_hist.prod_price, p_hist.DateOf_Purchase);
        toDetailedPurchaseHistoryIntent.putExtra("newPurchaseHistory",history);
        startActivity(toDetailedPurchaseHistoryIntent);
        //Toast.makeText(this,p_hist.prod_name + "-" + p_hist.prod_qty + "-" + p_hist.prod_price +"-" + p_hist.DateOf_Purchase,Toast.LENGTH_SHORT).show();
    }
}