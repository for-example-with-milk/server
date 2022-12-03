package example.milk.platform.server.repository;

import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.userservice.UserService;
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

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

//    public Optional<List<Service>> findAllById(String tag,String city)
//    {
//
//    }

    public Optional<Service> findById(Long id) {
        Service service = em.find(Service.class,id);
        return  Optional.ofNullable(service);
    }

    public boolean save(ServiceCreateRequestBody request) {

        Service service = request.getService();
        try {
            em.persist(service);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean saveServiceByObject(Service service) {
        try {
            em.persist(service);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    public UserService findUserServiceByUserId(Service service, String userId) {
        User user;
        TypedQuery<User> query = em.createQuery("select user from User as user where id=:id", User.class);
        query.setParameter("id", userId);

        try {
            user = (User) query.getResultList();
        } catch (Exception e) {
            return null;
        }

        TypedQuery<Long> query1 = em.createQuery("SELECT us FROM UserService as us WHERE Service=:serv AND User=:user", Long.class);
        query1.setParameter("serv", service);
        query1.setParameter("user", user);

        try {
            return (UserService) query1.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
