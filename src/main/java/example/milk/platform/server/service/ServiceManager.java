package example.milk.platform.server.service;

import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.responsebody.ServiceCreateResponseBody;
import example.milk.platform.server.repository.ServiceRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import javax.transaction.Transactional;

@Getter
@org.springframework.stereotype.Service
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
        return new ServiceCreateResponseBody(1,"서비스 생성을 성공했습니다.");
    }
}
