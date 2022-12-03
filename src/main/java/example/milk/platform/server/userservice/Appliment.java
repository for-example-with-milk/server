package example.milk.platform.server.userservice;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "sub_service_name")
    private String subServiceName;

    @Column(name = "time")
    private LocalDateTime time;

    @OneToMany(mappedBy = "appliment")
    List<AppliedElement> appliedElementList;
}
