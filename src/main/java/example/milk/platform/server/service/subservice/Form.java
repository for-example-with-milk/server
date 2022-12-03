package example.milk.platform.server.service.subservice;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "form")
public class Form {
    @Id
    @GeneratedValue
    @Column(name = "form_id")
    private Long id;

    @JoinColumn(name = "sub_service_id")
    @OneToOne(fetch = FetchType.LAZY)
    private SubService subService;

    @OneToMany(mappedBy = "form")
    private List<FormElement> formElementList;

    @Column(name = "is_purchase")
    private short isPurchase;

    @Column(name = "service_price")
    private int servicePrice;
}
