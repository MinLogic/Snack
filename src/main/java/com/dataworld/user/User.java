package com.dataworld.user;

import lombok.Getter;

@Getter
public class User {
    private String userId;
    private String userPw;

    private String delYn;

    public User(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
        this.delYn = "N";
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public void resetPassword() {
        this.userPw = "1q2w3e4r!";
    }

    public void modPassword(String userPw){
        this.userPw = userPw;
    }

    /*
    상태 = 단순한 값(속성)과 다른 객체(링크)로 표현할 수 있다
    행동 = 다른 객체에 서비스 한다
    객체는 객체를 인지할 수 있는 식별자가 있다.
    ex) 생성자
    VO DTO 는 값 객체이다. 엄밀히 말하면 객체도 아니고 단순 값.
    특정한 값을 받아서 소비하고 소멸하는 것이기에 객체라고 볼 수 없음.
    TIP. 이 시스템도 결국에는 데이터를 가지고 있게 되는 객체와 활동하는 객체로 나뉘게 될것이다.
    행동이 많다고 책임이 많은것은 아니다.
    다른 객체가 가지고 있어야 할 행동이나 책임과 상관없는 행동이 있을 경우를 책임이 많다고 한다.
    책임을 과도할 정도로 분리하는 것이 오히려 더 나은 방법이다.

    추상화
    대상 객체가 가지고 있는 수 많은 속성들중 꼭 필요한 것만 남기고 제거하는 개념
    공통점을 기반으로 객체들을 묶기 위한 그릇을 개념(concept)
    공학자들이 개념을 대체할 수 있는 좀 더 세련되 보이는 용어가 타입(type)

    Is-A 타입
    일반화 <-> 특수화
    유저 <-> 관리자, 승인자, 일반 사용자
    일반화 타입이 가지고 있는 기본 행동에 특수화 타입이 가지고 있는 행동이 추가되어 있는 경우를 뜻한

    객체의 역할, 책임, 협력
    스낵월드
    기준
    사용자, 승인자, 관리자
    상품(삭제라는 상태값을 가지고 있어야함), 상품리스트
    등등


    객체의 책임
    하는 것 - 객체를 생성하거나 계산 등의 스스로 하는것, 다른 객체의 활동을 제어하고 조절하는 것
    아는 것 - 개인적인 정보, 관련된 객체에 대해 아는 것

    객체의 역할
    객체의 협력

    아메 카푸 카라마끼 에스프레소 4가지 커피
    손님이 메뉴판을 보고 주문
    바리스타는 커피를 만들어 줌
    */

}
