**세션이란?**

세션이랑 웹 사이트의 여러 페이지에 걸쳐 사용되는 사용자 정보를 저장하는 방법을 의미  
사용자가 브라우저를 닫아 서버와의 연결을 끝내는 시점까지를 세션이라 한다

쿠키는 클라이언트 측에 데이터를 저장  
세션은 서비스가 돌아가는 서버 측에 데이터를 저장하며, 세션 키 값만을 클라이언트에 전달


**세션의 동작 순서**
1. 클라이언트가 페이지를 요청
2. 서버는 접근한 클라이언트의 Request-Header 의 Cookie를 확인,  
   클라이언트가 해당 Session-id 를 보냈는지 확인
3. Session-id 가 존재하지 않는 경우 서버는 Session-id 를 생성해서 보내준다
4. 클라이언트는 재접속 시 해당 Session-id 를 서버에 전달

|         |                     쿠키                     |             세션             |
|:--------|:------------------------------------------:|:--------------------------:|
| 저장 위치   |                   클라이언트                    |            웹 서버            |
| 저장 형식   |                    text                    |           Object           |
| 만료 시점   | 쿠키 저장시 설정<br/>(만료시점이 지나기 전까진 <br/>삭제되지 않음) | 브라우저 종료시 삭제<br/> (기간설정 가능) |
| 사용하는 자원 |                 클라이언트 리소스                  |          웹 서버 리소스          |
| 용량 제한   |     총 300개<br/>도메인 당 20개<br/>쿠키 당 4kb      |        서버가 허용하는 만큼         |
| 속도      |                  세션보다 빠름                   |          쿠키보다 느림           |
| 보안      |                  세션보다 안좋음                  |          쿠키보다 좋음           |