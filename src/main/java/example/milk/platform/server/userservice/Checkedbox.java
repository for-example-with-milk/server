package example.milk.platform.server.userservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Checkedbox {

    @Column(name = "checkedbox")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applied_element_id")
    private AppliedElement appliedElement;

    @Column(name = "name")
    private String name;

    public void setAppliedElement(AppliedElement appliedElement) {
        this.appliedElement = appliedElement;

    }
}
