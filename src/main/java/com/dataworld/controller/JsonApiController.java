package com.dataworld.controller;

import com.dataworld.webServer.http.HttpRequest;
import com.dataworld.webServer.http.HttpResponse;

public interface JsonApiController {
    String service(HttpRequest request, HttpResponse response);
}
