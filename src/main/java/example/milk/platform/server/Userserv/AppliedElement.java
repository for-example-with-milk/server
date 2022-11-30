package example.milk.platform.server.Userserv;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "applied_element")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
public class AppliedElement {

    @Column(name = "applied_element_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "application_id")
    private long applicationId;
}
