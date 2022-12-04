package example.milk.platform.server.service.subservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import example.milk.platform.server.service.Service;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "subservice")
@Getter
public class SubService {
    @Id
    @GeneratedValue
    @Column(name = "sub_service_id")
    private Long id;

    @JsonBackReference
    @JoinColumn(name = "service_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    @Column(name = "name")
    private String name;
    @Column(name = "lore")
    private String lore;
    @Column(name = "is_regular_payment")
    private short isRegularPayment;

    @JsonManagedReference
    @OneToOne(mappedBy = "subService")
    private Form form;

    protected SubService() {

    }

    public SubService(Service service, String name, String lore, short isRegularPaymentState) {
        this.service = service;
        this.name = name;
        this.lore = lore;
        this.isRegularPayment = isRegularPaymentState;
    }
}
