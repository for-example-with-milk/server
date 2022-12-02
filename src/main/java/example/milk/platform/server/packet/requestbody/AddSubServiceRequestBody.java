package example.milk.platform.server.packet.requestbody;

import example.milk.platform.server.service.subservice.*;
import lombok.Getter;

import java.util.List;

@Getter
public class AddSubServiceRequestBody {
    Long serviceId;
    SubService subService;
    List<ProdFormElement> prodFormElementList;
    List<InformationFormElement> informationFormElementList;
    List<IntegratedInputFormElement> integratedInputFormElementList;
    List<CheckInputFormElement> checkInputFormElementList;
    List<CheckBox> checkBox;
}
