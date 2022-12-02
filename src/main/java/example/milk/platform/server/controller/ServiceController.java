package example.milk.platform.server.controller;

import example.milk.platform.server.packet.requestbody.AddSubServiceRequestBody;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.AddSubServiceResponseBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceManager serviceManager;

    @PostMapping("/serv/create")
    public ServiceCreateResponseBody createService(@RequestBody ServiceCreateRequestBody request) {
        return serviceManager.createService(request);
    }
//    @GetMapping("/ser")
//    public String register_service(){
//        Long num = Long.valueOf(1);
//        List<SubService> subServiceList = new ArrayList<>();
//        Service service = new Service(num,"a","b","c","d","e","f",subServiceList);
//
//        serviceManager.createService(service);
//        return "redirect:/";
//    }
//test
}