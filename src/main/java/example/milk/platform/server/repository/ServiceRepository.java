package example.milk.platform.server.repository;

import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.ApplimentRequestBody;
import example.milk.platform.server.packet.requestbody.CreateSubServiceRequestBody;
import example.milk.platform.server.packet.requestbody.ServiceCreateRequestBody;
import example.milk.platform.server.service.Service;

import example.milk.platform.server.service.subservice.*;
import example.milk.platform.server.service.subservice.SubService;
import example.milk.platform.server.userservice.*;
import example.milk.platform.server.userservice.ElementType;
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
        System.out.println("test");

        if (query.getResultList().size() == 0)
            return false;
        return true;
    }

    public Optional<List<Service>> findListByTag(String tag){
        List<Service> serviceList;
        serviceList = em.createQuery("select m from Service m where m.categoryList LIKE :tag", Service.class)
                .setParameter("tag", '%'+tag+'%')
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

    public Optional<List<Service>> findListByUserId(String userId){
        List<Service> serviceList;
        serviceList = em.createQuery("select m from Service m where m.userId = :userId", Service.class)
                .setParameter("userId",userId)
                .getResultList();
        return Optional.ofNullable(serviceList);
    }

    public Optional<Service> findById(Long id) {
        Service service = em.find(Service.class, id);
        return  Optional.ofNullable(service);
    }

    public Service findServiceBySubServiceId(Long subServiceId) {
        TypedQuery<Service> query = em.createQuery("select s.service from SubService as s where s.id = :parm", Service.class);
        query.setParameter("parm", subServiceId);

        try {
            Service service = query.getResultList().get(0);
            return service;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean save(ServiceCreateRequestBody request) {

        Service service = request.getService();
        service.setUserId(request.getToken());
        try {
            em.persist(service);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Optional<List<SubService>> findSubServiceListByServiceId(Long serviceId){
        List<SubService> subServiceList;
        subServiceList = em.createQuery(
                "SELECT m FROM SubService m WHERE m.service.id = :serviceId", SubService.class)
                .setParameter("serviceId",serviceId)
                .getResultList();
        return Optional.ofNullable(subServiceList);
    }

    public boolean saveSubService(Service service, CreateSubServiceRequestBody request) {
        try {
            SubService subService = request.getSubService();
            Form form = request.getForm();
            List<FormElement> formElementList = request.getFormElementList();
            List<List<Checkbox>> checkboxLists = request.getCheckboxLists();

            int size = formElementList.size();
            int checkboxCnt = 0;
            for (int i = 0; i < size; i++) {
                FormElement formElement = formElementList.get(i);
                InputType inputType = formElement.getInputType();

                if ((inputType != null) && (inputType.equals(InputType.CHECKBOX))) {
                    List<Checkbox> checkboxList = checkboxLists.get(checkboxCnt);

                    int checkboxSize = checkboxList.size();
                    for (int j = 0; j < checkboxSize; j++) {
                        Checkbox checkbox = checkboxList.get(j);
                        checkbox.setFormElement(formElement);
                        em.persist(checkbox);
                    }

                    checkboxCnt++;
                }

                formElement.setForm(form);
                em.persist(formElement);
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

    public boolean saveApply(ApplimentRequestBody request, Service service, User user) {
        try {
            UserService userService = new UserService(service, user, (short) 1, null, request.getAppliment());
            Appliment appliment = request.getAppliment();
            Payment payment = request.getPayment();
            List<AppliedElement> appliedElementList = request.getAppliedElementList();
            List<List<Checkedbox>> checkedboxLists = request.getCheckedboxLists();

            int size = appliedElementList.size();
            int checkboxCnt = 0;
            for (int i = 0; i < size; i++) {
                AppliedElement appliedElement = appliedElementList.get(i);

                ElementType elementType = appliedElement.getElementType();
                if ((elementType != null) && (elementType.equals(ElementType.CHECKBOX))) {
                    List<Checkedbox> checkedboxList = checkedboxLists.get(checkboxCnt);

                    int checkedboxListSize = checkedboxList.size();
                    for (int j = 0; j < checkedboxListSize; j++) {
                        Checkedbox checkedbox = checkedboxList.get(j);
                        checkedbox.setAppliedElement(appliedElement);
                        em.persist(checkedbox);
                    }

                    checkboxCnt++;
                }
                appliedElement.setAppliment(appliment);
                em.persist(appliedElement);
            }
            appliment.setUserService(userService);
            em.persist(appliment);

            if (payment != null) {
                payment.setAppliment(appliment);
                em.persist(payment);
            }

            userService.setService(service);
            em.persist(userService);

            service.setUserService(userService);
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
