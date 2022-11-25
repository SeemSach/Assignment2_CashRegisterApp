package com.example.assignment2_cashregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
//Code Written By: Seema Shabadi 23/11/2022
//this activity is for manager control, to show the history transaction and to restock
public class ManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        Button toRestock_button = findViewById(R.id.restock_btn);
        Button toHistory_button = findViewById(R.id.history_btn);
        setTitle("Manager");
        toRestock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRestockIntent = new Intent(ManagerActivity.this, RestockActivity.class);
                startActivity(toRestockIntent);
            }
        });
        toHistory_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHistoryIntent = new Intent(ManagerActivity.this, HistoryActivity.class);
                startActivity(toHistoryIntent);
            }
        });
    }
}