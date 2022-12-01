package example.milk.platform.server.repository;

import example.milk.platform.server.service.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);
    Optional<Service> findByid(Long id);
    List<Service> findAll();
}
