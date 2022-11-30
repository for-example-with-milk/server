package example.milk.platform.server.AcountRepository;

import example.milk.platform.server.Account.ServiceProvider;
import example.milk.platform.server.Account.ServiceUser;
import example.milk.platform.server.Account.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements AccountRepositroy{

    private final EntityManager em;

    @Override
    public User saveServiceUser(ServiceUser serviceUser) {
        em.persist(serviceUser);
        return serviceUser;
    }

    @Override
    public User saveServiceProvider(ServiceProvider serviceProvider) {
        em.persist(serviceProvider);
        return serviceProvider;
    }

    @Override
    public String findProviderNameById(String id) {
        TypedQuery<String> query =
                em.createQuery("select p.provider_name from ServiceProvider as p where p.id = :parm", String.class);

        query.setParameter("parm", id);
        String providerName = query.getSingleResult();

        return providerName;
    }
}
