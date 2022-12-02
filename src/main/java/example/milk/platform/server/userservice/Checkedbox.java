package example.milk.platform.server.userservice;

import javax.persistence.*;

@Entity
public class Checkedbox {

    @Column(name = "checkedbox")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_applied_element")
    private CheckAppliedElement checkAppliedElement;
    
//    @Column(name = "check_applied_element_id")
//    private long checkAppliedElementId;
}
