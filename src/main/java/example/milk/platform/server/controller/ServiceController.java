package example.milk.platform.server.controller;

import example.milk.platform.server.account.AccountManager;
import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.*;
import example.milk.platform.server.packet.responsebody.*;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import example.milk.platform.server.service.subservice.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceManager serviceManager;

    private final AccountManager accountManager;

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
    public GetServiceListResponseBody findServiceListByTag(@RequestBody GetServiceListRequestBody request){
        GetServiceListResponseBody getServiceListResponseBody;
        List<Service> serviceList = serviceManager.findListByTag(request.getTag());
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
        List<Service> serviceList = serviceManager.findListByProviderId(request.getToken());
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
        List<Service> serviceList = serviceManager.findListByUserId(request.getToken());

        if(serviceList == null){
            getServiceListResponseBody = new GetUserServiceListResponseBody(1,"서비스가 존재하지 않습니다.", null);
        }
        else {
            getServiceListResponseBody = new GetUserServiceListResponseBody(0,"서비스 찾기 성공",serviceList);
        }
        return getServiceListResponseBody;
    }

    @PostMapping("/serv/getSubServiceList")
    public GetSubServiceListResponsebody findSubServiceListByServiceId(@RequestBody GetSubServiceListRequestbody request){
        GetSubServiceListResponsebody getSubServiceListResponsebody;

        Service service = serviceManager.findServiceById(request.getId());
        List<SubService> serviceList = serviceManager.findSubServiceListByServiceId(request.getId());

        if(serviceList == null && service == null){
            getSubServiceListResponsebody = new GetSubServiceListResponsebody(service,1,"서비스와 서브서비스 리스트가 존재하지 않습니다.", null);
        }
        else if (serviceList == null && service != null){
            getSubServiceListResponsebody = new GetSubServiceListResponsebody(service,2,"서비스가 존재하지 않습니다.",serviceList);
        }
        else if (serviceList != null && service == null){
            getSubServiceListResponsebody = new GetSubServiceListResponsebody(service,3,"서브서비스 리스트가 존재하지 않습니다.",serviceList);
        }
        else{
            getSubServiceListResponsebody = new GetSubServiceListResponsebody(service,0,"서비스 찾기 성공",serviceList);
        }
        return getSubServiceListResponsebody;
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
        User user = accountManager.getUser(request.getToken());
        Service service = serviceManager.findServiceBySubServiceId(request.getSubServiceId());

        int isValidate = service.isValidate(serviceManager.getServiceRepository(), request);
        if (isValidate != 0) {
            if (isValidate == 1)
                return new ApplimentResponseBody(3, "서비스 혹은 하위서비스, 신청양식이 없습니다.");
            else if (isValidate == 2)
                return new ApplimentResponseBody(4, "유효하지 않은 신청입니다.");
        }

        if (service == null) {
            return new ApplimentResponseBody(1, "서비스 혹은 하위서비스가 없습니다.");
        }
        if (user == null) {
            return new ApplimentResponseBody(2, "이용자가 없습니다.");
        }
        return service.saveApply(request, serviceManager.getServiceRepository(), user);
    }
}