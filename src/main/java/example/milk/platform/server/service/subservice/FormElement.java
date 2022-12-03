package example.milk.platform.server.service.subservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
@Table(name = "form_element")
public class FormElement {
    @Id
    @GeneratedValue
    @Column(name = "form_element_id")
    private Long id;

    @Column(name = "element_type")
    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    @JoinColumn(name = "form_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_description")
    private String prodDescription;

    @Column(name = "info_text")
    private String infoText;

    @Column(name = "input_type")
    @Enumerated(EnumType.STRING)
    private InputType inputType;

    @Column(name = "is_require_response")
    private short isRequireResponse;

    @Column(name = "is_multiple_choice")
    private short isMultipleChoice;

    @OneToMany(mappedBy = "formElement")
    private List<Checkbox> checkboxList;
}
