package example.milk.platform.server.service.subservice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("B")
public class ServiceTypeForm extends Form {
    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "serviceTypeForm")
    private List<FormElement> formElementList = new ArrayList<>();

}
