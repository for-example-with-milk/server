package example.milk.platform.server.service.subservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "form_element")
public class FormElement {
    @Id
    @GeneratedValue
    @Column(name = "form_element_id")
    private Long id;

    @Column(name = "idx")
    private int idx;

    @Column(name = "element_type")
    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    @JsonBackReference
    @JoinColumn(name = "form_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_description")
    private String prodDescription;

    @Column(name = "prod_price")
    private int prodPrice;

    @Column(name = "info_text")
    private String infoText;

    @Column(name = "input_type")
    @Enumerated(EnumType.STRING)
    private InputType inputType;

    @Column(name = "is_require_response")
    private short isRequireResponse;

    @Column(name = "is_multiple_choice")
    private short isMultipleChoice;

    @JsonManagedReference
    @OneToMany(mappedBy = "formElement")
    private List<Checkbox> checkboxList;

    public void setForm(Form form) {
        this.form = form;
        form.setFormElement(this);
    }

    public void setCheckbox(Checkbox checkbox) {
        if (this.checkboxList == null)
            this.checkboxList = new ArrayList<>();

        this.checkboxList.add(checkbox);
    }
}
