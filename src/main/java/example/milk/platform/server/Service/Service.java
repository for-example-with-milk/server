package example.milk.platform.server.Service;

import example.milk.platform.server.Service.SubService.SubService;
import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "serv")
@Getter
public class Service {
    @Id
    @GeneratedValue
    @Column(name = "serv_id")
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
//
    public Service(Long id, String name, String icoUrl, String lore, String city, String categoryList, String account, List<SubService> subServiceList) {
        this.id = id;
        this.name = name;
        this.icoUrl = icoUrl;
        this.lore = lore;
        this.city = city;
        this.categoryList = categoryList;
        this.account = account;
        this.subServiceList = subServiceList;
    }
}
