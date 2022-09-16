package com.dataworld.controller;

import com.dataworld.service.db.Users;
import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;
import com.dataworld.service.user.User;
import com.dataworld.webServer.http.HttpSession;

public class LoginController extends AbstractController {

    Users users = new Users();

    @Override
    public void doPost(HttpRequest request, HttpResponse response) {
        User loginUser = users.retrieveUser(request.getParameter("ID"));

        if (loginUser != null) {
            if (loginUser.login(request.getParameter("PW"))) {
                String sessionId = HttpSession.makeNewSession(loginUser);
                response.addHeader("Set-cookie", "SESSION-ID=" + sessionId + "; Path=/;");
                response.sendRedirect("/home.html");
                return;
            }
        }
        response.sendRedirect("/index.html");
    }

    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        String sessionId = request.getHeader("SESSION-ID");
        String path = request.getPath();
        response.forward("./src/main/webapp" + path + ".html");

        if (sessionId == null) {
            return;
        }
        response.sendRedirect("/home.html");
    }
}
