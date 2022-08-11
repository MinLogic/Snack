package com.dataworld.service.db;

import com.dataworld.service.product.Product;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Getter
public class Products {
    private static final Logger log = LoggerFactory.getLogger(Products.class);
    // TODO List -> Map
    public static ArrayList<Product> products = new ArrayList<>();

    public Products(){    }

    public int countProductsList(){
        return products.size();
    }

    public ArrayList<Product> retrieveAllProducts() {
        return products;
    }

    public Product retrieveProduct(String productId) {
        Product target = null;
        for (Product item : products) {
            String itemName = item.getProductId();
            if(itemName.equals(productId)){
                target = item;
            }
        }
        // delYn check
        if (target != null && !isDeleted(target)) {
            return target;
        }
        return null;
    }

    // 상품명 사용해서 리스트 검색
    public ArrayList<Product> searchProductList(String goodsName){
        ArrayList<Product> retrievedList = new ArrayList<>();
        for(Product item : products){
            String itemName = item.getProductName();
            if(itemName.contains(goodsName) && !isDeleted(item)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }

    public void regProduct(Product product) {
        products.add(product);
        log.info("Product registration success");
    }

    public void delProduct(String productId) {
        Product target = retrieveProduct(productId);
        if(target != null){
            target.delProduct("Y");
            setTargetProduct(target);
            log.info("Product deletion success");
            return;
        }
        log.info("Product deletion failure");
        log.info("Product has already been deleted or does not exist");
    }

    public void modProduct(String productId, String productName, Integer price) {
        Product target = retrieveProduct(productId);
        if (target != null) {
            target.modProduct(productName, price);
            log.info("Product Modification success");
            return;
        }
        log.info("Product Modification failure");
        log.info("Product does not exist");

    }

    public boolean isDeleted(Product item) {
        if ("N".equals(item.getDelYn())) {
            return false;
        }
        return true;
    }
    private void setTargetProduct(Product target) {
        int index = products.indexOf(target);
        products.set(index, target);
    }

    // ID 사용해서 상품 1개만 검색

}
