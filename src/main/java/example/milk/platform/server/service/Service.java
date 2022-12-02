package example.milk.platform.server.service;

import example.milk.platform.server.packet.requestbody.AddSubServiceRequestBody;
import example.milk.platform.server.packet.responsebody.AddSubServiceResponseBody;
import example.milk.platform.server.repository.ServiceRepository;
import example.milk.platform.server.service.subservice.Form;
import example.milk.platform.server.service.subservice.ProdFormElement;
import example.milk.platform.server.service.subservice.SubService;
import example.milk.platform.server.userservice.UserService;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service")
@Getter
public class Service {
    @Id
    @GeneratedValue
    @Column(name = "service_id")
    private Long id;

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
    private String account;

    @OneToMany(mappedBy = "service")
    private List<SubService> subServiceList = new ArrayList<>();

    protected Service() {
    }

    public Service(String name, String icoUrl, String lore, String city, String categoryList, String account) {
        this.name = name;
        this.icoUrl = icoUrl;
        this.lore = lore;
        this.city = city;
        this.categoryList = categoryList;
        this.account = account;
        this.subServiceList = subServiceList;
    }

    public SubService getSubService(Long id) {
        for (SubService subService : subServiceList) {
            if (subService.getId() == id)
                return subService;
        }

        return null;
    }

    public List<SubService> getSubServiceList() {
        return this.subServiceList;
    }

    public UserService getUserServiceList(ServiceRepository serviceRepository, String userId) {
        return serviceRepository.findUserServiceByUserId(this, userId);
    }
}