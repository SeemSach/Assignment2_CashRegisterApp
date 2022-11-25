package com.example.assignment2_cashregisterapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//Code Written By: Seema Shabadi 23/11/2022
//Manager restocks the stock
public class RestockActivity extends AppCompatActivity implements View.OnClickListener {
    ProductDetailsList_CustomAdapter product_list_adapter;
    Button ok_button;
    Button cancel_button;
    TextView restock_prod_type_text;
    EditText restock_new_quantity;
    ListView restock_product_list;
    int selectedProductIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        ok_button = findViewById(R.id.ok_btn);
        cancel_button = findViewById(R.id.cancel_btn);
        restock_prod_type_text = findViewById(R.id.restockProd_Type);
        restock_product_list = findViewById(R.id.restockProduct_list);
        restock_new_quantity = findViewById(R.id.restock_new_qty);
        ok_button.setOnClickListener(this);
        cancel_button.setOnClickListener(this);
        setTitle("Re-Stock");
        product_list_adapter = new ProductDetailsList_CustomAdapter(((MyApp)getApplication()).myStore.getList(),this);
        restock_product_list.setAdapter(product_list_adapter);
        restock_product_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             restock_prod_type_text.setText(((MyApp)getApplication()).myStore.productDetails[i].prod_name);
             selectedProductIndex = i;
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.ok_btn:
                if(restock_prod_type_text.getText().toString().equals("Product Type")||restock_new_quantity.getText().toString().isEmpty()) {

                   Toast.makeText(RestockActivity.this, "Please enter information in all fields...", Toast.LENGTH_LONG).show();
                }
                  else {
                    ((MyApp) getApplication()).myStore.productDetails[selectedProductIndex].addQuantity(Integer.parseInt(restock_new_quantity.getText().toString()));
                    product_list_adapter.prod_list = ((MyApp)getApplication()).myStore.getList();
                    product_list_adapter.notifyDataSetChanged();
                    showAlert();
//                    finish();
//                    Intent toMainActivityIntent = new Intent(RestockActivity.this, MainActivity.class);
//                    startActivity(toMainActivityIntent);
                }
                break;
            case R.id.cancel_btn:
                finish();
                break;
        }
    }

    void showAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stock Updated! Do you want to continue updating stock?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                restock_prod_type_text.setText("Product Type");
                restock_new_quantity.setText("");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                Intent toMainActivityIntent = new Intent(RestockActivity.this, MainActivity.class);
                startActivity(toMainActivityIntent);

            }

        });
    builder.create().show();
    }
}