package com.dataworld.db;

import com.dataworld.product.Product;
import com.dataworld.server.WebServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Products {
    private static final Logger log = LoggerFactory.getLogger(Products.class);

    private static Products instance = new Products();
    private ArrayList<Product> productList;

    private Products(){
        productList = new ArrayList<>();
    }

    public static Products getInstance(){
        return instance;
    }

    public int countProductsList(){
        return productList.size();
    }

    public void regProduct(Product product) {
        Product tempItem = retrieveProduct(product.getProductName());

        if(tempItem != null){
            if(!isDeleted(tempItem)){
                log.info("Product registration failure");
                log.info("{} is already registered", product.getProductName());
                return;
            }
            productList.remove(tempItem);
        }

        productList.add(product);
        log.info("Product registration success");
    }
    public void delProduct(String productName) {
        Product tempItem = retrieveProduct(productName);
        if(tempItem != null){
            if(isDeleted(tempItem)){
                log.info("Product deletion failure");
                log.info("{} is already deleted", productName);
                return;
            }
        } else if (tempItem == null) {
            log.info("Product deletion failure");
            log.info("{} does not exist", productName);
            return;
        }
        tempItem.setDelYn("Y");
        log.info("Product deletion success");
    }

    public ArrayList<Product> searchGoodsList(String goodsName){
        ArrayList<Product> retrievedList = new ArrayList<>();
        for(Product item : productList){
            String itemName = item.getProductName();
            if(itemName.contains(goodsName)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }

    public boolean isDeleted(Product item) {
        if ("N".equals(item.getDelYn())) {
            return false;
        }
        return true;
    }

    public Product retrieveProduct(String productName) {
        for (Product item : productList) {
            String itemName = item.getProductName();
            if(itemName.equals(productName)){
                return item;
            }
        }
        return null;
    }


    public boolean deleteProduct(){
        return false;
    }


    public void deleteGoods(String goodsName){
        // 향상된 for 문 사용시 ConcurrentModificationException 발생
        for(int i = 0; i< productList.size(); i++){
            Product item = productList.get(i);
            String itemName = item.getProductName();
            if(itemName.equals(goodsName)){
                productList.remove(item);
            }
        }
    }

    public Product retrieveGoods(String goodsName) {
        for(int i = 0; i< productList.size(); i++){
            Product item = productList.get(i);
            String itemName = item.getProductName();
            if(itemName.equals(goodsName)){
                return item;
            }
        }
        return null;
    }
}
