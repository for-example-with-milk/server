package example.milk.platform.server.Repository;

import example.milk.platform.server.Service.Service;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);
    Optional<Service> findByid(Long id);
    List<Service> findAll();
}
