package example.milk.platform.server.controller;

import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.*;
import example.milk.platform.server.packet.responsebody.*;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import example.milk.platform.server.service.subservice.*;
import example.milk.platform.server.userservice.AppliedElement;
import example.milk.platform.server.userservice.Appliment;
import example.milk.platform.server.userservice.ElementType;
import example.milk.platform.server.userservice.Payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public GetServiceResponseBody findById(@RequestBody GetServiceRequestBody request){
        GetServiceResponseBody getServiceResponseBody;
        getServiceResponseBody = new GetServiceResponseBody(0,"서비스 찾기 성공",serviceManager.findServiceById(request.getId()));
        return getServiceResponseBody;
    }

    @PostMapping("/serv/getlist")
    public GetServiceListResponseBody findServiceListBytag(@RequestBody GetServiceListRequestBody request){
        GetServiceListResponseBody getServiceListResponseBody;
        List<Service> serviceList = serviceManager.findlistByTag(request.getTag());
        if(serviceList == null){
            getServiceListResponseBody = new GetServiceListResponseBody(1,"서비스가 존재하지 않습니다.", null);
        }
        else {
            getServiceListResponseBody = new GetServiceListResponseBody(0,"서비스 찾기 성공",serviceList);
        }
        return getServiceListResponseBody;
    }

    @PostMapping("/serv/getprovlist")
    public GetProvServiceListResponseBody findProvServiceById(@RequestBody GetProvServiceListRequestBody request){
        GetProvServiceListResponseBody getServiceListResponseBody;
        List<Service> serviceList = serviceManager.findlistByProviderId(request.getToken());
        if(serviceList == null){
            getServiceListResponseBody = new GetProvServiceListResponseBody(1,"서비스가 존재하지 않습니다.", null);
        }
        else {
            getServiceListResponseBody = new GetProvServiceListResponseBody(0,"서비스 찾기 성공",serviceList);
        }
        return getServiceListResponseBody;
    }


    @PostMapping("/serv/getUserlist")
    public GetUserServiceListResponseBody findUserServiceById(@RequestBody GetUserServiceListRequestBody request){
        GetUserServiceListResponseBody getServiceListResponseBody;
        List<Service> serviceList = serviceManager.findlistByUserId(request.getToken());

        if(serviceList == null){
            getServiceListResponseBody = new GetUserServiceListResponseBody(1,"서비스가 존재하지 않습니다.", null);
        }
        else {
            getServiceListResponseBody = new GetUserServiceListResponseBody(0,"서비스 찾기 성공",serviceList);
        }
        return getServiceListResponseBody;
    }

    @PostMapping("/subserv/create")
    public CreateSubServiceResponseBody createSubService(@RequestBody CreateSubServiceRequestBody request) {
        Service service = serviceManager.findServiceById(request.getServiceId());
        if (service == null) {
            return new CreateSubServiceResponseBody(1, "서비스가 존재하지 않습니다.");
        }

        return service.saveSubService(request, serviceManager.getServiceRepository());
    }

    @PostMapping("/appliment")
    public ApplimentResponseBody apply(@RequestBody ApplimentRequestBody request) {
        Service service = serviceManager.findServiceBySubServiceId(request.getSubServiceId());
        if (service == null) {
            return new ApplimentResponseBody(1, "서비스 혹은 하위서비스가 없습니다.");
        }

        return service.saveApply(request, serviceManager.getServiceRepository());
    }

//    @GetMapping("/get/json")
//    public CreateSubServiceRequestBody createSubServiceRequestBody() {
//
//        SubService subService = new SubService("우유정기배달", "우유 정기 배달해드림", (short) 1);
//
//        Form form = new Form((short )1, 0);
//
//        List<FormElement> formElementList = new ArrayList<>();
//        formElementList.add(new FormElement(1, ElementType.INFORMATION, "원하는 배달 요일을 써주세요"));
//        formElementList.add(new FormElement(2, ElementType.INPUT, InputType.TEXT, (short) 1));
//        formElementList.add(new FormElement(3, ElementType.PRODUCT, "흰우유", "고소함", 1800));
//        formElementList.add(new FormElement(4, ElementType.PRODUCT, "초코우유", "달달함", 2000));
//        formElementList.add(new FormElement(5, ElementType.PRODUCT, "딸기우유", "상큼함", 2000));
//
//        CreateSubServiceRequestBody requestBody = new CreateSubServiceRequestBody(
//                9L, subService, form, formElementList, null);
//
//        return requestBody;
//    }

//    @GetMapping("/getjson")
//    public ApplimentRequestBody applimentRequestBody() {
//
//        User user = new User("id1", "aa", "usr1", "000-0000-0000");
//
//        LocalDateTime time = LocalDateTime.now();
//
//        Appliment appliment = new Appliment("우유 배달", time);
//
//        Payment payment = new Payment(time, "카드", 8000);
//
//        List<AppliedElement> appliedElementList = new ArrayList<>();
//        appliedElementList.add(new AppliedElement((short) 1, example.milk.platform.server.userservice.ElementType.TEXT, "대구 북구 경진로12길 xx, 201호"));
//        appliedElementList.add(new AppliedElement((short) 3, example.milk.platform.server.userservice.ElementType.PRODUCT, "초코우유", 2000, 4));
//
//
//        ApplimentRequestBody requestBody = new ApplimentRequestBody(
//                user,
//                9L,
//                appliment,
//                payment,
//                appliedElementList,
//                null
//                );
//
//        return requestBody;
//    }
}