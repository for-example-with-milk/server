package example.milk.platform.server.userservice;

import javax.persistence.*;

@Entity
public class Checkedbox {

    @Column(name = "checkedbox")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applied_element_id")
    private AppliedElement appliedElement;

    @Column(name = "name")
    private String name;
}
