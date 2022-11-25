package com.example.assignment2_cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
//Code Written By: Seema Shabadi 23/11/2022
//Following class is to display the purchase history details whenever user clicks on row in PurchaseHistory activity table
public class DetailedPurchaseHistory extends AppCompatActivity {
TextView purchasedProduct;
TextView purchasedProductQuantity;
TextView purchasedTotalBill;
TextView purchasedDateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_purchase_history);
        purchasedProduct = findViewById(R.id.purchased_prod_name);
        purchasedProductQuantity = findViewById(R.id.purchased_prod_quantity);
        purchasedTotalBill = findViewById(R.id.purchased_TotalBill);
        purchasedDateTime = findViewById(R.id.purchasedOnDateTime);
        setTitle("Purchase History Details");
        //Create an Intent object to receive the intent from it's previous intent
        Intent resultIntent = getIntent();
        //Create a parcelable object to receive incoming parcelable object
        History h = (History) resultIntent.getParcelableExtra("newPurchaseHistory");
        purchasedProduct.setText("Product: "+h.product_name);
        purchasedProductQuantity.setText("Quantity: "+h.product_quantity);
        purchasedTotalBill.setText("Total: "+String.valueOf(h.total_bill));
        purchasedDateTime.setText("Purchased On: "+h.purchase_date);
    }
}