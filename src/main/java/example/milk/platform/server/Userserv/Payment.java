package example.milk.platform.server.Userserv;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
public class Payment {

    @Column(name = "payment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "application_id")
    private long applicationId;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private int amount;
}
