package example.milk.platform.server.controller;

import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.GetServiceResponseBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

}