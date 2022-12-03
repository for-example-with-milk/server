package example.milk.platform.server.userservice;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "applied_element")
@Getter
public class AppliedElement {

    @Column(name = "applied_element_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "appliment_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Appliment appliment;

    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_price")
    private int prodPrice;

    @Column(name = "prod_num")
    private int prodNum;

    @Column(name = "text")
    private String text;

    // 이진데이터 구현 X

    @OneToMany(mappedBy = "appliedElement")
    private List<Checkedbox> checkedboxList;
}
