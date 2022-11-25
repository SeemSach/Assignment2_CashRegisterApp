package com.example.assignment2_cashregisterapp;
//Code Written By: Seema Shabadi 23/11/2022
//model class
//Class to store purchase history
public class PurchaseHistory extends ProductDetails{
 String DateOf_Purchase;
    public PurchaseHistory(String prod_name, int prod_qty, double prod_price, String purchaseDate) {
        super(prod_name, prod_qty, prod_price);
         this.DateOf_Purchase = purchaseDate;
    }
}
