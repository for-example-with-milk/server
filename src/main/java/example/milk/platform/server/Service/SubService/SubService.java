package example.milk.platform.server.Service.SubService;

import example.milk.platform.server.Service.Service;

import javax.persistence.*;

@Entity
@Table(name = "subserv")
public class SubService {
    @Id
    @GeneratedValue
    @Column(name = "subserv_id")
    private Long id;

    @JoinColumn(name = "serv_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    @Column(name = "name")
    private char name;
    @Column(name = "lore")
    private char lore;
    @Column(name = "regular_payment_state")
    private short regular_payment_state;

    private SubService() {

    }

    public SubService(Long id, Service service, char name, char lore, short regular_payment_state) {
        this.id = id;
        this.service = service;
        this.name = name;
        this.lore = lore;
        this.regular_payment_state = regular_payment_state;
    }


}
