package com.example.assignment2_cashregisterapp;

import android.os.Parcel;
import android.os.Parcelable;
//Code Written By: Seema Shabadi 23/11/2022
//This is a parcelable class to pass the values across the activities through intent as parcelable object
//Parcelable works only on primitive data types
//Declare all the variables that you want to pass in parcelable object
public class History implements Parcelable {
   String product_name;
   int product_quantity;
   double total_bill;
   String purchase_date;
   public History(String prod_name, int prod_quantity,double total, String date_of_purchase)
   {
       this.product_name = prod_name;
       this.product_quantity = prod_quantity;
       this.total_bill = total;
       this.purchase_date = date_of_purchase;
   }
   //Following methods will help preparing data to parcel and adding them in parcel
    protected History(Parcel in) {
product_name = in.readString();
product_quantity = in.readInt();
total_bill = in.readDouble();
purchase_date = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(product_name);
        parcel.writeInt(product_quantity);
        parcel.writeDouble(total_bill);
        parcel.writeString(purchase_date);
    }
}
