package example.milk.platform.server.Service.SubService;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("E")
public class CheckInputFormElement extends InputFormElement{

    @Column(name = "multiple_choice_state")
    private short multipleChoiceState;

    @Column(name = "boxtype")
    private String boxType;

    @Column(name = "inputtype")
    private String inputType;

    @OneToMany(mappedBy = "checkInputFormElement")
    private List<CheckBox> checkBoxList = new ArrayList<>();
}
