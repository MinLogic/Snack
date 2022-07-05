package com.dataworld.controller;

import com.dataworld.http.HttpRequest;
import com.dataworld.http.HttpResponse;

public interface JsonApiController {
    String service(HttpRequest request, HttpResponse response);
}
