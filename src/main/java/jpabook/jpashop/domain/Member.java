package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    /* ManyToOne에 대응하는 양방향 매핑을 할경우, mappedBy를 통해 대응되는 곳의 변수명을 입력해줘야한다.
    양방향 관계는 사실 단반향 관계 2개라고 생각하면 된다.
    외래키가 있는 곳을 주인으로 정하면 된다.
    양방향 매핑의 규칙
    1. 객체의 두 관계중 하나를 연관관계의 주인으로 지정
    2. 연관관계의 주인만이 외래키를 관리 (등록, 수정)
    3. 주인이 아닌쪽은 읽기만 가능
    4. 주인은 mappedBy 속성 사용X
    5. 주인이 아니면 mappedBy 속성으로 주인 지정

    양방향 매핑은 반대방향으로 조회 기능이 추가된 것 뿐이다. 단방향을 잘 연결하고, 필요할 때 양방향 해주면 된다.*/
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
