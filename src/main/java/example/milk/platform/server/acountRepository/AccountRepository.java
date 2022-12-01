package example.milk.platform.server.acountRepository;

import example.milk.platform.server.account.ServiceProvider;
import example.milk.platform.server.account.ServiceUser;
import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

    public User saveServiceUser(ServiceUser serviceUser) {
        em.persist(serviceUser);
        return serviceUser;
    }

    public User saveServiceProvider(ServiceProvider serviceProvider) {
        em.persist(serviceProvider);
        return serviceProvider;
    }

    public String findProviderNameById(String id) {
        TypedQuery<String> query =
                em.createQuery("select p.provider_name from ServiceProvider as p where p.id = :parm", String.class);

        query.setParameter("parm", id);
        String providerName = query.getSingleResult();

        return providerName;
    }

    public boolean existUserById(String id) {
        TypedQuery<String> query = em.createQuery("SELECT id FROM User WHERE id=:id", String.class);
        query.setParameter("id", id);

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

    public boolean signUpUser(SignUpUserRequestBody request) {
        ServiceUser user = new ServiceUser(request.getId(), request.getPw(), request.getName(), request.getPhone_number(), request.getAddress(), request.getAge(), request.getGender(), request.getTagList());
        try {
            em.persist(user);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
