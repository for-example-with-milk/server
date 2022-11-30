package example.milk.platform.server.Userserv;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("C")
@Getter
public class CheckAppliedElement extends AppliedElement {

    @OneToMany(mappedBy = "checkAppliedElement")
    private List<Checkbox> checkBoxList;
}
