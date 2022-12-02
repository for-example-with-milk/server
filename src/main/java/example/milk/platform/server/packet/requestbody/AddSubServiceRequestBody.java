package example.milk.platform.server.packet.requestbody;

import example.milk.platform.server.service.subservice.*;
import lombok.Getter;

import java.util.List;

@Getter
public class AddSubServiceRequestBody {
    Long serviceId;
    String name;
    String lore;
    short regularPaymentState;

    List<ProdFormElement> prodFormElementList;
    List<InputFormElement> inputFormElementList;
    List<IntegratedInputFormElement> integratedInputFormElementList;
    List<CheckInputFormElement> checkInputFormElements;
    List<CheckBox> checkBox;
}
