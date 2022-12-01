package example.milk.platform.server.entity.service.subservice;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("A")
public class PurchaseElementForm extends Form {

    @OneToMany(mappedBy = "purchaseElementForm")
    private List<ProdFormElement> prodFormElementList = new ArrayList<>();
}
