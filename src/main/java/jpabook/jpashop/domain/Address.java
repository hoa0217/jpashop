package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// 값타입은 변경이 불가능하게 설계해야함 (Setter X)
@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    /**
     * jpa스펙상 생성
     *
     * jpa 기술을 써야하는데 기본생성자가 없으면, 불가능하기 때문에 기본생성자 생성
     * 대신 public으로 선언하면 사람들이 많이 사용하기 때문에 protected로 선언
     */
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
