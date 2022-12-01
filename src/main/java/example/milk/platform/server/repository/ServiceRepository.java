package example.milk.platform.server.repository;

import example.milk.platform.server.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServiceRepository {

    private final EntityManager em;
    public void save(Service service) {
        em.persist(service);
    }

    public Optional<Service> findByid(Long id) {
        //Service service = em.find();
        return Optional.empty();
    }

    public List<Service> findAll() {
        return null;
    }
}
