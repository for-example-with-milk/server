package example.milk.platform.server.Userserv;

import javax.persistence.*;

@Entity
public class Checkbox {

    @Column(name = "checkbox")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_applied_element")
    private CheckAppliedElement checkAppliedElement;
    
//    @Column(name = "check_applied_element_id")
//    private long checkAppliedElementId;
}
