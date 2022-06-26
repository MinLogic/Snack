package com.dataworld.server;

import com.dataworld.snackworld.Goods;
import com.dataworld.snackworld.GoodsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public class RequestHandler extends Thread{
    private Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private Socket connection;

    public RequestHandler(Socket socket){
        this.connection = socket;
    }

    @Override
    public void run() {
        log.debug("New Client Connect! Connect IP: {}, Port: {}", connection.getInetAddress(), connection.getPort());

        try (InputStream in = connection.getInputStream();
             OutputStream out = connection.getOutputStream()) {
            //TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();

            log.debug("request line : {}", line);

            if(line.equals(null)){
                return;
            }

            String[] tokens = line.split(" ");

            while(!"".equals(line)){
                line = br.readLine();
                log.debug("header : {}", line);
            }



            if("/product/regForm".equals(tokens[1])){
                // 상품 폼 페이지
                DataOutputStream dos = new DataOutputStream(out);
                byte[] body = Files.readAllBytes(new File("./src/main/webapp" + tokens[1] + ".html").toPath());
                response200Header(dos, body.length);
                responseBody(dos, body);
            }

            if("/product".equals(tokens[1])){
                // 상품 등록
                String content = br.readLine();
                String[] contentToken = content.split("&");

                String goodsName = contentToken[0].split("=")[1];
                int goodsPrice = Integer.parseInt(contentToken[1].split("=")[1]);
                GoodsList goodsList = GoodsList.getInstance();
                goodsList.addGoods(new Goods(goodsName, goodsPrice));

                Goods goods = goodsList.retrieveGoods(goodsName);
                log.debug("success");
                log.debug("goodsName : {}", goods.getGoodsName());
                log.debug("goodsPrice : {}", goods.getPrice());
            }


        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html; charset=utf-8 \r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes( "\r\n");


        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }


    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.writeBytes( "\r\n");
            dos.flush();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
