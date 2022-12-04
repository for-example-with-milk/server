package example.milk.platform.server.service.subservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "form")
public class Form {
    @Id
    @GeneratedValue
    @Column(name = "form_id")
    private Long id;

    @JsonBackReference
    @JoinColumn(name = "sub_service_id")
    @OneToOne(fetch = FetchType.LAZY)
    private SubService subService;

    @NotNull
    @JsonManagedReference
    @OneToMany(mappedBy = "form")
    private List<FormElement> formElementList;

    @Column(name = "is_purchase")
    private short isPurchase;

    @Column(name = "service_price")
    private int servicePrice;

    protected Form() {}

    public Form(short isPurchase, int servicePrice) {
        this.isPurchase = isPurchase;
        this.servicePrice = servicePrice;
    }

    public void setSubService(SubService subService) {
        this.subService = subService;
        subService.setForm(this);
    }

    public void setFormElement(FormElement formElement) {
        if (this.formElementList == null)
            this.formElementList = new ArrayList<>();

        this.formElementList.add(formElement);
    }
}
