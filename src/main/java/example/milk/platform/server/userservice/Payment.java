package example.milk.platform.server.userservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Long id;

    @JsonBackReference
    @JoinColumn(name = "appliment")
    @OneToOne(fetch = FetchType.LAZY)
    private Appliment appliment;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private int amount;

    public void setAppliment(Appliment appliment) {
        this.appliment = appliment;
        appliment.setPayment(this);
    }
}
