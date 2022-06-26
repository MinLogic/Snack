package com.dataworld.snackworld;

import java.util.ArrayList;

public class GoodsList {
    private static GoodsList instance = new GoodsList();
    private ArrayList<Goods> itemList;

    private GoodsList(){
        itemList = new ArrayList<>();
    }

    public static GoodsList getInstance(){
        return instance;
    }

    public int countGoodsList(){
        return itemList.size();
    }



    public void addGoods(Goods goods) {
        itemList.add(goods);
    }

    public ArrayList<Goods> searchGoodsList(String goodsName){
        ArrayList<Goods> retrievedList = new ArrayList<>();
        for(Goods item : itemList){
            String itemName = item.getGoodsName();
            if(itemName.contains(goodsName)){
                retrievedList.add(item);
            }
        }
        return retrievedList;
    }


    public void deleteGoods(String goodsName){
        // 향상된 for 문 사용시 ConcurrentModificationException 발생
        for(int i=0; i<itemList.size(); i++){
            Goods item = itemList.get(i);
            String itemName = item.getGoodsName();
            if(itemName.equals(goodsName)){
                itemList.remove(item);
            }
        }
    }

    public Goods retrieveGoods(String goodsName) {
        for(int i=0; i<itemList.size(); i++){
            Goods item = itemList.get(i);
            String itemName = item.getGoodsName();
            if(itemName.equals(goodsName)){
                return item;
            }
        }
        return null;
    }
}
