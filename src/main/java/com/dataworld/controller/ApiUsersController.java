package com.dataworld.controller;

import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ApiUsersController implements Controller {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        try {
            PrintWriter out = response.getWriter();
            response.addHeader("Content-type", "application/json");
            out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//        extends AbstractController {
//    @Override
//public void doGet(HttpRequest request, HttpResponse response) {
//        JSONArray jsonArray = makeJsonArray();
//
//    }
//
//    public JSONArray makeJsonArray() {
//
//        Users users = Users.getInstance();
//        List<User> userList = users.getUserList();
//
//        JSONArray jsonArray = new JSONArray();
//        for (User user : userList) {
//            JSONObject jsonObject = new JSONObject();
//
//            jsonObject.put("userId", user.getUserId());
//            jsonObject.put("userPw", user.getUserPw());
//            jsonObject.put("delYn", user.getDelYn());
//
//            jsonArray.add(jsonObject);
//        }
//
//        return jsonArray;
//    }
//}
