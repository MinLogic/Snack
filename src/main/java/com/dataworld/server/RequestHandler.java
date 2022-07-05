package com.dataworld.server;

import com.dataworld.controller.Controller;
import com.dataworld.http.HttpRequest;
import com.dataworld.http.HttpResponse;
import com.dataworld.product.Product;
import com.dataworld.db.Products;
import com.dataworld.user.User;
import com.dataworld.db.Users;
import com.dataworld.util.HttpRequestUtils;
import com.dataworld.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Map;
import java.util.Objects;

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
            HttpRequest httpRequest = new HttpRequest(in); // 이거 하나로 퉁칠수 있게 만들것
            HttpResponse httpResponse = new HttpResponse(out);
            String url = getDefaultPath(httpRequest.getPath());  //-> 인덱스로 가는 거

            Controller controller = RequestMapping.getController(url);
            if (Objects.isNull(controller)) {
                String path = getDefaultPath(url);
            } else {
                controller.service(httpRequest, httpResponse);
            }


            // client 가 ajax 콜을 하면
            // ex) api/users
            //      유저 정보를 JSON 형태로 모두 반환


//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            String line = br.readLine();
//
//            log.debug("request line : {}", line);
//
//            if(line.equals(null)){
//                return;
//            }
//
//            String[] tokens = line.split(" ");
//
//            while(!"".equals(line)){
//                line = br.readLine();
//                log.debug("header : {}", line);
//                if(line.contains("Content-length")){
//
//                }
//            }
            // line 중에 contains content-length 해서 content-length 구하기
            // content-length 길이로 char[] 만들기 ?? byte[] 만들기?
            // inputstream 을 content-length 만큼 읽어서 char[] 에 넣기
            // 해당 데이터를 byte로 변환
            
            // 서블릿 내용 기억해라
            // response add Header "Set-Cookie"  ex) "logined-true"
            // Cookie key jsessionid 를 가지고 쿠키를 던지면 해당 id를 가지고 세션이 살아있는지 죽었는지 확인
            
            // 정리 http 는 세션을 쿠키로 관리
            // 서블릿 컨테이너에서 서블릿이 jsessionid 를 사용해 관리

//            String content = "";
//            if("POST".equals(tokens[0])){
//                content = br.readLine();
//                content = postHandler(br);
//            }

//            if("POST".equals(tokens[0])){
//                while(br.ready()){
//                    char[] test = new char[100];
//                    br.read(test,0,40);
//                    log.debug("content : {}", String.valueOf(test));
//                }
//            }

            int contentLength = 0; // 나중에 위로 빼야함
            url= null;
            if ("/user/create".equals(url)) {
//                String body = IOUtils.readData(br, contentLength);
//                Map<String, String> params = HttpRequestUtils.parseQueryString(body);
//                User user = new User(params.get("userId"), params.get("password"));
//                // userlist 클래스에 정의해둔 addUser 불러와서 실행
//                DataOutputStream dos = new DataOutputStream(out);
//                // redirect 를 해야함
//                // redirect는 302 헤더를 가지고 넘어가야함

            } else if ("/user/regform".equals(url)) {

            }

            String[] contentTokens;
            if("/product/regForm".equals(url)){
//                // 상품 폼 페이지
//                DataOutputStream dos = new DataOutputStream(out);
//                byte[] body = Files.readAllBytes(new File("./src/main/webapp" + url + ".html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
            }

            if("/product".equals(url)){
                //
//                String body = IOUtils.readData(br, contentLength);
//                // 상품 등록
//                // Map 으로 변환하는 방법 찾아보기
//                contentTokens = content.split("&");
//
//                String goodsName = contentTokens[0].split("=")[1];
//                int goodsPrice = Integer.parseInt(contenturl.split("=")[1]);
//
//                Products products = Products.getInstance();
//                products.regProduct(new Product(goodsName, goodsPrice));


//                DataOutputStream dos = new DataOutputStream(out);
//                byte[]  = Files.readAllBytes(new File("./src/main/webapp/product/regForm.html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
            }

            if("/login/loginForm".equals(url)){
//                // 상품 폼 페이지
//                DataOutputStream dos = new DataOutputStream(out);
//                byte[] body = Files.readAllBytes(new File("./src/main/webapp" + url + ".html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
            }

            if("/login".equals(url)){
//                contentTokens = content.split("&");
//
//                String Id = contentTokens[0].split("=")[1];
//                String Pw = contenturl.split("=")[1];
//
//                Users users = Users.getInstance();
//
//                if(!users.login(Id, Pw)){
//                    log.debug("login 실패");
//                    return;
//                }
//                log.debug("login 성공");
//
//
//                DataOutputStream dos = new DataOutputStream(out);
//                byte[] body = Files.readAllBytes(new File("./src/main/webapp/login/loginForm.html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
            }

            if("/login/regUserForm".equals(url)){
                // 상품 폼 페이지
//                DataOutputStream dos = new DataOutputStream(out);
//                byte[] body = Files.readAllBytes(new File("./src/main/webapp" + url + ".html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
            }

            if("/user".equals(url)){
//                contentTokens = content.split("&");
//
//                String Id = contentTokens[0].split("=")[1];
//                String Pw = contenturl.split("=")[1];
//
//                Users users = Users.getInstance();
//
//
//                users.regUser(new User(Id, Pw));
//
//
//                DataOutputStream dos = new DataOutputStream(out);
//                byte[] body = Files.readAllBytes(new File("./src/main/webapp/login/loginForm.html").toPath());
//                response200Header(dos, body.length);
//                responseBody(dos, body);
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
            dos.writeBytes("Sek-Cookie: logined=true; Path=/ \r\n"); // 쿠키담는거
            dos.writeBytes( "\r\n");

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response302Header(DataOutputStream dos) {
        try {
            dos.writeBytes("HTTP/1.1 302 OK \r\n");
            dos.writeBytes("Location: /index.html \r\n"); // redirect 해줄 페이지 주소
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


    private String postHandler(BufferedReader br){
        StringBuilder sb = new StringBuilder();
        try{
           while(br.ready()){
               String line = br.readLine();
               log.debug("content : {}", line);
               sb.append(line);
               sb.append("&");
           }
       } catch (IOException e) {
           log.error(e.getMessage());
       }
        return sb.toString();
    }

    private String getDefaultPath(String path) {
        if (path.equals("/")) {
            return "/index.html";
        }
        return path;
    }
}
