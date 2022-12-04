package example.milk.platform.server.service;

import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.repository.ServiceRepository;
import example.milk.platform.server.service.subservice.SubService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Getter
@RequiredArgsConstructor
@Transactional
public class ServiceManager {
    private final ServiceRepository serviceRepository;

    public ServiceCreateResponseBody createService(ServiceCreateRequestBody request){
        try {
            if (!serviceRepository.save(request)) {
                return new ServiceCreateResponseBody(1, "서비스 생성을 실패했습니다.");
            }
        }
        catch (Exception e){
            return new ServiceCreateResponseBody(2 ,"서비스 생성을 실패했습니다.");
        }
        System.out.println("생성 성공");
        return new ServiceCreateResponseBody(0,"서비스 생성을 성공했습니다.");
    }

    public example.milk.platform.server.service.Service findServiceById(Long serviceId) {
        example.milk.platform.server.service.Service service = serviceRepository.findById(serviceId).get();
        return service;
    }

    public List<Service> findlistByTag(String tag,String city){
        Optional<List<Service>> serviceList = serviceRepository.findListByTag(tag,city);
        List<Service> result = serviceList.orElse(null);
        if ( result == null){
            return null;
        }
        else{
            return result;
        }
    }
    public List<Service> findlistByProviderId(String id){
        Optional<List<Service>> serviceList = serviceRepository.findListByProviderId(id);
        List<Service> result = serviceList.orElse(null);
        if ( result == null){
            return null;
        }
        else{
            return result;
        }
    }

    public List<SubService> findSubServicelistByServiceid(Long serviceId){
        List<SubService> result = serviceRepository
                .findSubServiceListByServiceId(serviceId)
                .orElse(null);
        if ( result == null){
            return null;
        }
        else{
            return result;
        }
    }

//    public List<example.milk.platform.server.service.Service> findlistByUserId(String id){
//        Optional<List<example.milk.platform.server.service.Service>> serviceList = serviceRepository.findListByProviderId(id);
//        example.milk.platform.server.service.Service service = new example.milk.platform.server.service.Service();
//        UserService userService;
//        userService.getUser(serviceRepository,id);
//        List<example.milk.platform.server.service.Service> result = serviceList.orElse(null);
//        if ( result == null){
//            return null;
//        }
//        else{
//            return result;
//        }
//    }
}
