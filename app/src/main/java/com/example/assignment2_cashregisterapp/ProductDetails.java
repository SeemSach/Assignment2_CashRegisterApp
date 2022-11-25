package com.example.assignment2_cashregisterapp;
//Code Written By: Seema Shabadi 23/11/2022
//Enter the product details by initializing the product stock
//model class
public class ProductDetails {
    String prod_name;
    int prod_qty;
    double prod_price;
    public ProductDetails(String prod_name,int prod_qty, double prod_price)
    {
        this.prod_name = prod_name;
        this.prod_qty = prod_qty;
        this.prod_price = prod_price;
    }
//update the stock whenever purchase has been made
    public void updateQuantity(int qty)
    {
       this.prod_qty = this.prod_qty - qty;
    }
    //add the quantities of products stock whenever restock is done
    public void addQuantity(int qty){this.prod_qty = this.prod_qty + qty;}
}
