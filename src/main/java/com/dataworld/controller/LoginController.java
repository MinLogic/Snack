package com.dataworld.controller;

import com.dataworld.service.db.Users;
import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;
import com.dataworld.service.user.User;

public class LoginController extends AbstractController {

    Users users = Users.getInstance();

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        User loginUser = users.retrieveUser(request.getParameter("ID"));

        if (loginUser != null) {
            if (loginUser.login(request.getParameter("PW"))) {
                response.addHeader("Set-cookie", "logined=true; Path=/;");
                response.addHeader("Set-cookie", "SESSIONID=abdccddsfsdee; Path=/;");
                response.sendRedirect("/home.html");
                return;
            }
        }
        response.sendRedirect("/index.html");
    }

    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        String path = request.getPath();
        response.forward("./src/main/webapp" + path + ".html");
    }
}
