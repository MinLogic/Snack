package com.dataworld.snackworld;

public class Goods {

    private String goodsName;
    private int price;

    public Goods(String goodsName, int price){
        this.goodsName = goodsName;
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getPrice() {
        return price;
    }


    // 원시 값 포장, 유효성 검사
}
