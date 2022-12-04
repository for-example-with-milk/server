package example.milk.platform.server.controller;

import example.milk.platform.server.packet.requestbody.CreateSubServiceRequestBody;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.CreateSubServiceResponseBody;
import example.milk.platform.server.packet.responsebody.GetServiceResponseBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceManager serviceManager;

    @PostMapping("/serv/create")
    public ServiceCreateResponseBody createService(@RequestBody ServiceCreateRequestBody request) {
        ServiceCreateResponseBody serviceCreateResponseBody = serviceManager.createService(request);
        System.out.println(serviceCreateResponseBody.getMessage());
        System.out.println(serviceCreateResponseBody.getResult());
        return serviceCreateResponseBody;
    }

    @PostMapping("/serv/get")
    public GetServiceResponseBody findById(@RequestBody ServiceCreateRequestBody request){
        GetServiceResponseBody getServiceResponseBody;
        getServiceResponseBody = new GetServiceResponseBody(1,"서비스 찾기 성공",serviceManager.findServiceById(request.getId()));
        return getServiceResponseBody;

    }

    @PostMapping("/subserv/create")
    public CreateSubServiceResponseBody createSubService(@RequestBody CreateSubServiceRequestBody request) {
        Service service = serviceManager.findServiceById(request.getServiceId());

        if (service == null) {
            return new CreateSubServiceResponseBody(1, "서비스가 존재하지 않습니다.");
        }

        return service.saveSubService(request, serviceManager.getServiceRepository());
    }

//    @GetMapping("/get/json")
//    public CreateSubServiceRequestBody createSubServiceRequestBody() {
//
//        SubService subService = new SubService("학생증발급배달", "학생증 발급해서 배달해드림", (short) 0);
//
//        Form form = new Form((short )0, 4500);
//
//        List<FormElement> formElementList = new ArrayList<>();
//        formElementList.add(new FormElement(ElementType.INFORMATION, "아래에 모바일 학생증을 올려주세요."));
//        formElementList.add(new FormElement(ElementType.INPUT, InputType.FILE, (short) 0));
//        formElementList.add(new FormElement(ElementType.INFORMATION, "학년을 선택해주세요."));
//        formElementList.add(new FormElement(ElementType.INPUT, InputType.CHECKBOX, (short) 1, (short) 0));
//        formElementList.add(new FormElement(ElementType.INFORMATION, "학점을 선택해주세요."));
//        formElementList.add(new FormElement(ElementType.INPUT, InputType.CHECKBOX, (short) 1, (short) 0));
//
//        List<Checkbox> checkboxList1 = new ArrayList<>();
//        checkboxList1.add(new Checkbox("1학년"));
//        checkboxList1.add(new Checkbox("2학년"));
//        checkboxList1.add(new Checkbox("3학년"));
//
//        List<Checkbox> checkboxList2 = new ArrayList<>();
//        checkboxList2.add(new Checkbox("1점대"));
//        checkboxList2.add(new Checkbox("2점대"));
//        checkboxList2.add(new Checkbox("3점대"));
//        checkboxList2.add(new Checkbox("4점대"));
//
//        List<List<Checkbox>> checkboxLists = new ArrayList<>();
//        checkboxLists.add(checkboxList1);
//        checkboxLists.add(checkboxList2);
//
//
//        CreateSubServiceRequestBody requestBody = new CreateSubServiceRequestBody(
//                5L, subService, form, formElementList, checkboxLists);
//
//        return requestBody;
//    }
}