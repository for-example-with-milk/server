package example.milk.platform.server.repository;

import example.milk.platform.server.account.ServiceProvider;
import example.milk.platform.server.account.ServiceUser;
import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.SignUpProvRequestBody;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
import example.milk.platform.server.packet.responsebody.GetNameResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final EntityManager em;

    public boolean existUserById(String id) {
        TypedQuery<String> query = em.createQuery("SELECT id FROM User WHERE id=:id", String.class);
        query.setParameter("id", id);

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

    public boolean signUpUser(SignUpUserRequestBody request) {
        ServiceUser user = new example.milk.platform.server.account.ServiceUser(request.getId(), request.getPw(), request.getName(), request.getPhoneNumber(), request.getAddress(), request.getAge(), request.getGender(), request.getTagList());

        try {
            em.persist(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean signUpProvider(SignUpProvRequestBody request) {
        ServiceProvider provider = new example.milk.platform.server.account.ServiceProvider(request.getId(), request.getPw(), request.getName(), request.getPhoneNumber(), request.getProviderName());

        try {
            em.persist(provider);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ServiceUser matchAccountUser(String id, String pw) {
        TypedQuery<ServiceUser> query = em.createQuery("SELECT p FROM ServiceUser AS p WHERE id=:id AND pw=:pw", ServiceUser.class);
        query.setParameter("id", id);
        query.setParameter("pw", pw);

        List<ServiceUser> result = query.getResultList();

        if (result.size() == 0)
            return null;
        return result.get(0);
    }

    public ServiceProvider matchAccountProvider(String id, String pw) {
        TypedQuery<ServiceProvider> query = em.createQuery("SELECT p FROM ServiceProvider AS p WHERE id=:id AND pw=:pw", ServiceProvider.class);
        query.setParameter("id", id);
        query.setParameter("pw", pw);

        List<ServiceProvider> result = query.getResultList();

        if (result.size() == 0)
            return null;
        return result.get(0);
    }

    public String getNameById(String id) {
        TypedQuery<String> query = em.createQuery(
                "select name from ServiceUser where id = :parm", String.class);
        query.setParameter("parm", id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String getProvNameById(String id) {
        TypedQuery<String> query = em.createQuery(
                "select providerName from ServiceProvider where id = :parm", String.class);
        query.setParameter("parm", id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public User findUserById(String userId) {
        TypedQuery<User> query = em.createQuery("select u from User as u where id = :parm", User.class);
        query.setParameter("parm", userId);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
