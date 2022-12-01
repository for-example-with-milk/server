package example.milk.platform.server.service.subservice;

import javax.persistence.*;

@Entity
@Table(name = "checkbox")
public class CheckBox {
    @Id
    @GeneratedValue
    @Column(name = "checkbox_id")
    private Long Id;

    @JoinColumn(name = "form_element_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CheckInputFormElement checkInputFormElement;

    @Column(name = "name")
    private String name;

}
