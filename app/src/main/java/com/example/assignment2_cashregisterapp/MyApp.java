package com.example.assignment2_cashregisterapp;

import android.app.Application;


import java.util.ArrayList;

//Code Written By: Seema Shabadi 23/11/2022
public class MyApp extends Application {
    //As we need our data to be accessible across all the activities; we are creating a global level variable
    //This store object will give us common access to the class data across activities
    Store myStore = new Store();
  }
