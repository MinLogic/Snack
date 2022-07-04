package com.dataworld.product;

import lombok.Getter;

@Getter
public class Product {

    private String productName;
    private int price;

    private String delYn;

    public Product(String productName, int price){
        this.productName = productName;
        this.price = price;
        this.delYn = "N";
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    // 원시 값 포장, 유효성 검사
}
