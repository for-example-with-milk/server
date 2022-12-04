package example.milk.platform.server.repository;

import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.subservice.SubService;
import example.milk.platform.server.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServiceRepository {

    private final EntityManager em;


    public boolean existServiceById(Long id) {
        TypedQuery<Long> query = em.createQuery("SELECT id FROM Service WHERE id=:id", Long.class);
        query.setParameter("id", id);
        System.out.println("test");

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

    public Optional<List<Service>> findListByTag(String tag,String city){
        List<Service> serviceList;
        serviceList = em.createQuery("select m from Service m where m.categoryList LIKE :tag and m.city = :city", Service.class)
                .setParameter("tag", '%'+tag+'%')
                .setParameter("city",city)
                .getResultList();
        return Optional.ofNullable(serviceList);
    }

    public Optional<List<Service>> findListByProviderId(String prov_id){
        List<Service> serviceList;
        serviceList = em.createQuery("select m from Service m where m.userId = :prov_id", Service.class)
                .setParameter("prov_id",prov_id)
                .getResultList();
        return Optional.ofNullable(serviceList);
    }

    public Optional<List<Service>> findListByUserId(String prov_id){
        List<Service> serviceList;
        serviceList = em.createQuery("select m from Service m where m.userServiceList = :prov_id", Service.class)
                .setParameter("prov_id",prov_id)
                .getResultList();
        return Optional.ofNullable(serviceList);
    }

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
//
//    public Optional<List<SubService>> findSubServiceListByServiceId(Long serviceId){
//        List<SubService> subServiceList;
//
//        subServiceList  = em.createQuery(
//                        "SELECT m FROM SubService m WHERE m.service.id = :serviceId", SubService.class)
//                .setParameter("serviceId",serviceId)
//                .getResultList();
//        return Optional.ofNullable(subServiceList);
//    }

    public Optional<List<SubService>> findSubServiceListByServiceId(Long serviceId){
        List<SubService> subServiceList;
        subServiceList = em.createQuery(
                "SELECT m FROM SubService m WHERE m.service.id = :serviceId", SubService.class)
                .setParameter("serviceId",serviceId)
                .getResultList();
        return Optional.ofNullable(subServiceList);
    }

//    "SELECT s.subServiceList FROM Service s WHERE s.id = :serviceId"
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
        TypedQuery<User> query = em.createQuery("select user from User as user where user.id=:id", User.class);
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
