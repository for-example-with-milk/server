package example.milk.platform.server.service;

import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.repository.ServiceRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Getter
@Service
@RequiredArgsConstructor
@Transactional
public class ServiceManager {
    private final ServiceRepository serviceRepository;

    public ServiceCreateResponseBody createService(ServiceCreateRequestBody request){
        try {
            if (!serviceRepository.save(request)) {
                return new ServiceCreateResponseBody(0, "서비스 생성을 실패했습니다.");
            }
        }
        catch (Exception e){
            return new ServiceCreateResponseBody(0 ,"서비스 생성을 실패했습니다.");
        }
        System.out.println("생성 성공");
        return new ServiceCreateResponseBody(1,"서비스 생성을 성공했습니다.");
    }

    public example.milk.platform.server.service.Service findServiceById(Long serviceId) {
        Optional<example.milk.platform.server.service.Service> service = serviceRepository.findById(serviceId);
        return service.orElse(null);
    }

    public List<example.milk.platform.server.service.Service> findlistByTag(String tag,String city){
        Optional<List<example.milk.platform.server.service.Service>> serviceList = serviceRepository.findListByTag(tag,city);
        return serviceList.orElse(null);
    }
}
