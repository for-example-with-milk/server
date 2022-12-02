package example.milk.platform.server.service.subservice;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("A")
public class PurchaseTypeForm extends Form {

    @OneToMany(mappedBy = "purchaseTypeForm")
    private List<ProdFormElement> prodFormElementList = new ArrayList<>();
}
