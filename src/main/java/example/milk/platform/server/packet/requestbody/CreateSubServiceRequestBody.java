package example.milk.platform.server.packet.requestbody;

import example.milk.platform.server.service.subservice.Checkbox;
import example.milk.platform.server.service.subservice.Form;
import example.milk.platform.server.service.subservice.FormElement;
import example.milk.platform.server.service.subservice.SubService;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateSubServiceRequestBody {
    private Long serviceId;
    private SubService subService;
    private Form form;
    private List<FormElement> formElementList;
    private List<List<Checkbox>> checkboxLists;

    public CreateSubServiceRequestBody(Long serviceId, SubService subService, Form form, List<FormElement> formElementList, List<List<Checkbox>> checkboxLists) {
        this.serviceId = serviceId;
        this.subService = subService;
        this.form = form;
        this.formElementList = formElementList;
        this.checkboxLists = checkboxLists;
    }
}
