package example.milk.platform.server.repository;

import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.CreateSubServiceRequestBody;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.subservice.*;
import example.milk.platform.server.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class ServiceRepository {

    private final EntityManager em;


    public boolean existServiceById(Long id) {
        TypedQuery<Long> query = em.createQuery("SELECT id FROM Service WHERE id=:id", Long.class);
        query.setParameter("id", id);

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

    public Optional<Service> findById(Long id) {
        Service service = em.find(Service.class, id);
        return  Optional.ofNullable(service);
    }

    public boolean save(ServiceCreateRequestBody request) {

        Service service = new Service(request.getName(), request.getIcoUrl(), request.getLore(), request.getCity(), request.getCategoryList(), request.getAccount());
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

    public boolean saveSubService(Service service, CreateSubServiceRequestBody resquest) {
        try {
            SubService subService = resquest.getSubService();
            Form form = resquest.getForm();
            List<FormElement> formElementList = resquest.getFormElementList();
            List<List<Checkbox>> checkboxLists = resquest.getCheckboxLists();

            System.out.println("여기 됨");
            int size = formElementList.size();
            int checkboxCnt = 0;
            for (int i = 0; i < size; i++) {
                System.out.println("여기 됨!");
                FormElement formElement = formElementList.get(i);

                InputType inputType = formElement.getInputType();

                System.out.println("여기 됨!!");
                if ((inputType != null) && (inputType.equals(InputType.CHECKBOX))) {
                    System.out.println("여기 됨!!!");
                    List<Checkbox> checkboxList = checkboxLists.get(checkboxCnt);

                    System.out.println("여기 됨!!!!");
                    int checkboxSize = checkboxList.size();
                    for (int j = 0; j < checkboxSize; j++) {
                        Checkbox checkbox = checkboxList.get(j);

                        System.out.println("여기 됨!!!! !");
                        checkbox.setFormElement(formElement);
                        em.persist(checkbox);
                        System.out.println("여기 됨!!!! !!");
                    }

                    checkboxCnt++;
                }
                System.out.println("여기됨!!!! !!!");

                formElement.setForm(form);
                System.out.println("여기됨!!!! !!!!");

                em.persist(formElement);
                System.out.println("여기됨!!!! !!!! !");
            }
            form.setSubService(subService);
            em.persist(form);

            subService.setService(service);
            em.persist(subService);
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
