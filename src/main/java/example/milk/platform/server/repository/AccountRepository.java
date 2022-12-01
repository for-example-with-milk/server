package example.milk.platform.server.repository;

import example.milk.platform.server.entity.account.ServiceProvider;
import example.milk.platform.server.entity.account.ServiceUser;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
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
        example.milk.platform.server.account.ServiceUser user = new example.milk.platform.server.account.ServiceUser(request.getId(), request.getPw(), request.getName(), request.getPhone_number(), request.getAddress(), request.getAge(), request.getGender(), request.getTagList());
        example.milk.platform.server.entity.account.ServiceUser entity = user.toEntity();
        try {
            em.persist(entity);
        }
        catch (Exception e) {
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
}
