package example.milk.platform.server.service.subservice;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "checkbox")
@Getter @Setter
public class Checkbox {
    @Id
    @GeneratedValue
    @Column(name = "checkbox_id")
    private Long Id;

    @JsonBackReference
    @JoinColumn(name = "form_element_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private FormElement formElement;

    @Column(name = "name")
    private String name;

    @Column(name = "idx")
    int elementIdx;

    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;

        formElement.setCheckbox(this);
    }
}
