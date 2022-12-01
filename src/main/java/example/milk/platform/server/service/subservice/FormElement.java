package example.milk.platform.server.service.subservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
@Table(name = "form_element")
public class FormElement {
    @Id
    @GeneratedValue
    @Column(name = "form_element_id")
    private Long id;

    @JoinColumn(name = "form_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceTypeForm serviceTypeForm;
}
