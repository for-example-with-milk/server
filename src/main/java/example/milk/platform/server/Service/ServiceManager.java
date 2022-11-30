package example.milk.platform.server.Service;

import example.milk.platform.server.Repository.MysqlServiceRepository;
import lombok.RequiredArgsConstructor;


import javax.transaction.Transactional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Transactional
public class ServiceManager {

    private final MysqlServiceRepository mysqlServiceRepository;

    public void createService(Service service){
        mysqlServiceRepository.save(service);
    }


}
