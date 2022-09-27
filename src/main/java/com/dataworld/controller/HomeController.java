package com.dataworld.controller;

import com.dataworld.service.user.Auth;
import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;
import com.dataworld.webServer.http.HttpSession;

public class HomeController extends AbstractController{
    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        Auth auth = HttpSession.getUserAuth(request.getSession());

        if (auth == Auth.ADMIN) {
            response.sendRedirect("/adminHome.html");
        } else if (auth == Auth.APPROVER) {
            // 권한이 승인자일 경우
        }
        // 권한이 일반일 경우

    }

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        String path = request.getPath();
        response.forward("./src/main/webapp" + path + ".html");
    }
}
