package example.milk.platform.server.Repository;

import example.milk.platform.server.Service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MysqlServiceRepository implements ServiceRepository{

    private final EntityManager em;
    @Override
    public void save(Service service) {
        em.persist(service);
    }

    @Override
    public Optional<Service> findByid(Long id) {
        //Service service = em.find();
        return Optional.empty();
    }

    @Override
    public List<Service> findAll() {
        return null;
    }
}
