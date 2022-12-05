package example.milk.platform.server.service;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import example.milk.platform.server.account.User;
import example.milk.platform.server.packet.requestbody.ApplimentRequestBody;
import example.milk.platform.server.packet.requestbody.CreateSubServiceRequestBody;
import example.milk.platform.server.packet.responsebody.ApplimentResponseBody;
import example.milk.platform.server.packet.responsebody.CreateSubServiceResponseBody;
import example.milk.platform.server.repository.ServiceRepository;
import example.milk.platform.server.service.subservice.*;
import example.milk.platform.server.userservice.AppliedElement;
import example.milk.platform.server.userservice.UserService;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
@Getter @Setter
public class Service {
    @Id
    @GeneratedValue
    @Column(name = "service_id")
    private Long id;

    @JoinColumn(name = "user_id")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "ico_url")
    private String icoUrl;
    @Column(name = "lore")
    private String lore;
    @Column(name = "city")
    private String city;
    @Column(name = "category_list")
    private String categoryList;
    @Column(name = "account")
    private String bAccount;


    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private List<SubService> subServiceList = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    @JsonManagedReference
    private List<UserService> userServiceList = new ArrayList<>();

    protected Service() {
    }

    public Service(String name, String icoUrl, String lore, String city, String categoryList, String bAccount) {
        this.name = name;
        this.icoUrl = icoUrl;
        this.lore = lore;
        this.city = city;
        this.categoryList = categoryList;
        this.bAccount = bAccount;
    }

    public void setUserService(UserService userService) {
        if (this.userServiceList == null)
            this.userServiceList = new ArrayList<>();

        this.userServiceList.add(userService);
    }

    public CreateSubServiceResponseBody saveSubService(CreateSubServiceRequestBody request, ServiceRepository serviceRepository) {

        boolean result = serviceRepository.saveSubService(this, request);
        System.out.println(result);
        if (result == false)
            return new CreateSubServiceResponseBody(2, "하위서비스를 저장하지 못했습니다.");

        return new CreateSubServiceResponseBody(0, "성공했습니다.");
    }

    public ApplimentResponseBody saveApply(ApplimentRequestBody request, ServiceRepository serviceRepository, User user) {
        boolean result = serviceRepository.saveApply(request, this, user);

        System.out.println(result);
        if (result == false)
            return new ApplimentResponseBody(3, "저장하는 데 실패했습니다.");

        return new ApplimentResponseBody(0, "성공했습니다.");
    }

    public List<SubService> getSubServiceList() {
        return this.subServiceList;
    }

    public UserService getUserServiceList(ServiceRepository serviceRepository, String userId) {
        return serviceRepository.findUserServiceByUserId(this, userId);
    }

    public int isValidate(ServiceRepository serviceRepository, ApplimentRequestBody request) {
        List<FormElement> formElementList = serviceRepository.findFormElementList(request.getSubServiceId());

        if (formElementList == null)
            return 1;

        for (FormElement formElement : formElementList) {
            if (formElement.getIsRequireResponse() == 1) {
                int index = formElement.getIdx();

                List<AppliedElement> appliedElementList = request.getAppliedElementList();
                for (AppliedElement appliedElement : appliedElementList) {
                    if (appliedElement.getIdx() == index) {
                        return 0;
                    }
                }
            }
        }

        return 2;
    }
}