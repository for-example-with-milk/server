package example.milk.platform.server.Service.SubService;

import javax.persistence.*;

@Entity
@Table(name = "prod_form_element")
public class ProdFormElement {
    @Id
    @GeneratedValue
    @Column(name = "prod_apply_form_element_id")
    private Long id;


    @JoinColumn(name = "form_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseElementForm purchaseElementForm;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
}
