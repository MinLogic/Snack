package com.dataworld.controller;


import com.dataworld.webServer.http.HttpMethod;
import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// 컨트롤러 구현체
public abstract class AbstractController implements Controller {

    private Logger log = LoggerFactory.getLogger(AbstractController.class);

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        HttpMethod method = request.getMethod();
        if (method.isPost()) {
            doPost(request, response);
        } else {
            doGet(request,response);
        }

    }
    public void doGet(HttpRequest request, HttpResponse response) {

    }
    public void doPost(HttpRequest request, HttpResponse response) {

    }
}
