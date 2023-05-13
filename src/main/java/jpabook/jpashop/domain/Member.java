package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address; //jpa 내장타입

    @JsonIgnore
    @OneToMany(mappedBy = "member") // 나는 매핑된 거울이야 ! (읽기전용)
    private List<Order> orders = new ArrayList<>();

}
