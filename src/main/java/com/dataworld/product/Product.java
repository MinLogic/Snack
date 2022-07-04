package com.dataworld.product;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private String productId;
    private String productName;
    private int price;

    private String delYn;

    public Product(String productName, int price){
        this.productId = UUID.randomUUID()
                .toString()
                .replace("-", "");
        this.productName = productName;
        this.price = price;
        this.delYn = "N";
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public void modProduct(String productName, int price){
        this.productName = productName;
        this.price = price;
    }

    // 원시 값 포장, 유효성 검사
}
