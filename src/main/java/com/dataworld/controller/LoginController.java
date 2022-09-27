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
                response.sendRedirect("/home");
                return;
            }
        }
        response.sendRedirect("/index.html");
    }

    @Override
    public void doGet(HttpRequest request, HttpResponse response) {
        String sessionId = request.getHeader("SESSION-ID");
        String path = request.getPath();


        if (sessionId == null) {
            response.forward("./src/main/webapp" + path + ".html");
            return;
        }

        response.sendRedirect("/home");
    }
}
