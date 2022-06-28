package com.dataworld.http;

public enum HttpMethod {
    GET, POST;
    public boolean isPost(){
        return this == POST;
    }
}
