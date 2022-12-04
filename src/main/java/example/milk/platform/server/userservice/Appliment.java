package example.milk.platform.server.userservice;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appliment")
@Getter
public class Appliment {

    @Column(name = "appliment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_service_id")
    private Long userServiceId;

    @JsonManagedReference
    @OneToOne(mappedBy = "appliment")
    private Payment payment;

    @Column(name = "sub_service_name")
    private String subServiceName;

    @Column(name = "time")
    private LocalDateTime time;

    @JsonManagedReference
    @OneToMany(mappedBy = "appliment")
    List<AppliedElement> appliedElementList;

    protected Appliment() {}
    public Appliment(String subServiceName, LocalDateTime time) {
        this.subServiceName = subServiceName;
        this.time = time;
    }

    public void setAppliedElement(AppliedElement appliedElement) {
        if (this.appliedElementList == null)
            this.appliedElementList = new ArrayList<>();

        this.appliedElementList.add(appliedElement);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setUserService(UserService userService) {
        this.userServiceId = userService.getId();

    }
}
