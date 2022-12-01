package example.milk.platform.server.userserv;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
@Getter
public class Application {

    @Column(name = "application_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_service_id")
    private long userServiceId;

    @Column(name = "subservice_name")
    private String subserviceName;

    @Column(name = "time")
    private LocalDateTime time;
}
