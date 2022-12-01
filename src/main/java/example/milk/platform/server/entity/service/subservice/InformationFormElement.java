package example.milk.platform.server.entity.service.subservice;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class InformationFormElement extends FormElement{
    @Column(name = "text")
    private String text;
}
