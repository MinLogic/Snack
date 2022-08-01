package com.dataworld.service.db;

import com.dataworld.service.product.Product;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@Getter
public class Products {
    private static final Logger log = LoggerFactory.getLogger(Products.class);
    private static Products products = new Products();

    // TODO List -> Map
    private ArrayList<Product> productList;

    private Products(){
        productList = new ArrayList<>();
    }

    public static Products getProducts(){
        return products;
    }

    public int countProductsList(){
        return productList.size();
    }

    public void regProduct(Product product) {
        productList.add(product);
        log.info("Product registration success");
    }

    public void delProduct(String productId) {
        Product target = retrieveProduct(productId);
        if(target != null){
            target.setDelYn("Y");
            log.info("Product deletion success");
            return;
        }
        log.info("Product deletion failure");
        log.info("Product has already been deleted or does not exist");
    }

    public void modProduct(String productId, String name, int price) {
        Product target = retrieveProduct(productId);
        if (target != null) {
            target.modProduct(name, price);
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

    // ID 사용해서 상품 1개만 검색
    public Product retrieveProduct(String productId) {
        Product temp = null;
        for (Product item : productList) {
            String itemName = item.getProductId();
            if(itemName.equals(productId)){
                temp = item;
            }
        }
        if (temp != null) {
            if (!isDeleted(temp)) {
                return temp;
            }
        }
        return null;
    }

    // 상품명 사용해서 리스트 검색
    public ArrayList<Product> searchProductList(String goodsName){
        ArrayList<Product> retrievedList = new ArrayList<>();
        for(Product item : productList){
            String itemName = item.getProductName();
            String delYn = item.getDelYn();
            if(itemName.contains(goodsName) && "N".equals(delYn)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }
}
