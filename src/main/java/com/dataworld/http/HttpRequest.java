package com.dataworld.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequest {

    private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);


    private RequestLine requestLine;
    private HttpHeader header;
    private RequestParams requestParams = new RequestParams();

    public HttpRequest(InputStream in) {
        // bufferedReader 로 in 을 읽고
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

    }

}
