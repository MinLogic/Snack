package com.dataworld.controller;

import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;

public interface Controller {

    void service(HttpRequest request, HttpResponse response);

}
