package example.milk.platform.server.repository;

import example.milk.platform.server.account.ServiceUser;
import example.milk.platform.server.entity.account.ServiceProvider;
import example.milk.platform.server.entity.account.User;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
        ServiceUser user = new ServiceUser(request.getId(), request.getPw(), request.getName(), request.getPhone_number(), request.getAddress(), request.getAge(), request.getGender(), request.getTagList());
        example.milk.platform.server.entity.account.ServiceUser entity = user.toEntity();
        try {
            em.persist(entity);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean matchAccount(String id, String pw) {
        TypedQuery<String> query = em.createQuery("SELECT id FROM User WHERE id=:id AND pw=:pw", String.class);
        query.setParameter("id", id);
        query.setParameter("pw", pw);

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }
}
