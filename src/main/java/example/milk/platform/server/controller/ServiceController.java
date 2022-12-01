package example.milk.platform.server.controller;

import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import example.milk.platform.server.service.subservice.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceManager serviceManager;

    @GetMapping("/ser")
    public String register_service(){
        Long num = Long.valueOf(1);
        List<SubService> subServiceList = new ArrayList<>();
        Service service = new Service(num,"a","b","c","d","e","f",subServiceList);

        serviceManager.createService(service);
        return "redirect:/";
    }
}
