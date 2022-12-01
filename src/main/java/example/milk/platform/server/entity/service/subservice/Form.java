package example.milk.platform.server.entity.service.subservice;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Table(name = "form")
public abstract class Form {
    @Id
    @GeneratedValue
    @Column(name = "form_id")
    private Long id;

}
