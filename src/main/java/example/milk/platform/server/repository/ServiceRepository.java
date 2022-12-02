package example.milk.platform.server.repository;

import example.milk.platform.server.account.ServiceUser;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
import example.milk.platform.server.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServiceRepository {

    private final EntityManager em;


    public boolean existServiceById(Long id) {
        TypedQuery<Long> query = em.createQuery("SELECT id FROM Service WHERE id=:id", Long.class);
        query.setParameter("id", id);

        return query.getResultList().size() != 0;
    }

    public boolean save(ServiceCreateRequestBody request) {

        Service service = new Service(request.getName(), request.getIcoUrl(), request.getLore(), request.getCity(), request.getCategoryList(), request.getAccount());
        try {
            em.persist(service);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public Optional<Service> findById(Long id) {
        //Service service = em.find();
        return Optional.empty();
    }

    public List<Service> findAll() {
        return null;
    }
}
