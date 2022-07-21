package com.dataworld.webServer.http;

public enum HttpMethod {
    GET, POST;
    public boolean isPost(){
        return this == POST;
    }
}
