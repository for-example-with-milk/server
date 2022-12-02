package example.milk.platform.server.service.subservice;

import javax.persistence.*;

@Entity
@DiscriminatorValue("D")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public class InputFormElement extends FormElement{

    @Column(name = "required_response_state")
    private short RequiredResponseState;

}
