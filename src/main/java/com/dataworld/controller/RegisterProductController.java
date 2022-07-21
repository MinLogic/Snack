package com.dataworld.controller;

import com.dataworld.service.db.Products;
import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;

public class RegisterProductController extends AbstractController{
    Products products = Products.getInstance();

    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        String path = request.getPath();
        response.forward("./src/main/webapp" + path + ".html");
    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        // 로그인 된 유저 객체가 필요
        super.doPost(request, response);
    }
}
