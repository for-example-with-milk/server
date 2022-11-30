package example.milk.platform.server.Service.SubService;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class IntegratedInputFormElement extends InputFormElement{

    @Column(name = "input_kind")
    private String inputKind;
}
