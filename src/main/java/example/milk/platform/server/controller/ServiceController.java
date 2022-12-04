package example.milk.platform.server.controller;

import example.milk.platform.server.packet.requestbody.*;
import example.milk.platform.server.packet.responsebody.*;

import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import example.milk.platform.server.service.subservice.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        List<Service> serviceList = serviceManager.findlistByTag(request.getTag(), request.getCity());
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

    @PostMapping("/serv/getuserlist")
    public GetProvServiceListResponseBody findUserServiceById(@RequestBody GetProvServiceListRequestBody request){
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

    @PostMapping("/serv/getSublist")
    public GetSubServiceListResponsebody findUserServiceById(@RequestBody GetSubServiceListRequestbody request){
        GetSubServiceListResponsebody getServiceListResponseBody;
        List<SubService> serviceList = serviceManager.findSubServicelistByServiceid(request.getId());
        if(serviceList == null){
            getServiceListResponseBody = new GetSubServiceListResponsebody(1,"서비스가 존재하지 않습니다.", null);
        }
        else {
            getServiceListResponseBody = new GetSubServiceListResponsebody(0,"서비스 찾기 성공", serviceList);
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
}