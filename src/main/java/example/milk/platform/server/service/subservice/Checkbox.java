package example.milk.platform.server.service.subservice;

import javax.persistence.*;

@Entity
@Table(name = "checkbox")
public class Checkbox {
    @Id
    @GeneratedValue
    @Column(name = "checkbox_id")
    private Long Id;

    @JoinColumn(name = "form_element_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FormElement formElement;

    @Column(name = "name")
    private String name;
}
