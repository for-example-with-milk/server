package example.milk.platform.server.service.subservice;

import example.milk.platform.server.service.Service;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "subservice")
public class SubService {
    @Id
    @GeneratedValue
    @Column(name = "subservice_id")
    private Long id;

    @JoinColumn(name = "service_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    @Column(name = "name")
    private char name;
    @Column(name = "lore")
    private char lore;
    @Column(name = "regular_payment_state")
    private short regular_payment_state;

    protected SubService() {

    }

    public SubService(Long id, Service service, char name, char lore, short regular_payment_state) {
        this.id = id;
        this.service = service;
        this.name = name;
        this.lore = lore;
        this.regular_payment_state = regular_payment_state;
    }


}
