package example.milk.platform.server.service;

import example.milk.platform.server.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;


import javax.transaction.Transactional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class ServiceManager {
    private final ServiceRepository mysqlServiceRepository;
    public void createService(Service service){
        mysqlServiceRepository.save(service);
    }
}
