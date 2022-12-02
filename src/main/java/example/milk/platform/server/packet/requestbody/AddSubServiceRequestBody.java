package example.milk.platform.server.packet.requestbody;

import example.milk.platform.server.service.subservice.CheckBox;
import example.milk.platform.server.service.subservice.FormElement;
import example.milk.platform.server.service.subservice.ProdFormElement;
import lombok.Getter;

@Getter
public class AddSubServiceRequestBody {
    Long serviceId;
    String name;
    String lore;
    short regularPaymentState;

    ProdFormElement prodFormElement;
    FormElement formElement;
    CheckBox checkBox;
}
