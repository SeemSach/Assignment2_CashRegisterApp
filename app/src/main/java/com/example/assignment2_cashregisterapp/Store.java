package com.example.assignment2_cashregisterapp;
import java.util.ArrayList;
//Code Written By: Seema Shabadi 23/11/2022
//our model class where all data resides
public class Store  {
    ProductDetails[] productDetails;
    public Store() {
        productDetails = new ProductDetails[]{new ProductDetails("Pants", 10, 20.44),
                new ProductDetails("Shoes", 100, 10.44),
                new ProductDetails("Hats", 30, 5.9)};
        for (ProductDetails productDetail : productDetails) {
            addNewProduct(productDetail);
        }
    }
    private ArrayList<ProductDetails> listOfProducts= new ArrayList<>();


    public ArrayList<ProductDetails> getList(){
        if (listOfProducts == null) {
            listOfProducts = new ArrayList<>(0);
        }

        return listOfProducts;
    }
    public void addNewProduct(ProductDetails newProduct){
        listOfProducts.add(newProduct);
    }
    private ArrayList<PurchaseHistory> purchaseHistoryArrayList = new ArrayList<>();
    public ArrayList<PurchaseHistory> getPurchaseHistoryList()
    {
        if(purchaseHistoryArrayList == null)
        {
            purchaseHistoryArrayList = new ArrayList<>(0);
        }
        return purchaseHistoryArrayList;
    }
   public void addNewPurchaseHistory(PurchaseHistory newPurchase) {purchaseHistoryArrayList.add(newPurchase);}
}
