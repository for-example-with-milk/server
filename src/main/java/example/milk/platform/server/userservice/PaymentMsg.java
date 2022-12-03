package example.milk.platform.server.userservice;

import javax.persistence.*;

@Entity
@DiscriminatorValue("P")
public class PaymentMsg extends ChatMsg{

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "text")
    private String text;
}
