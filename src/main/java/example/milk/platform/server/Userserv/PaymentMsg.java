package example.milk.platform.server.Userserv;

import javax.persistence.*;

@Entity
@DiscriminatorValue("P")
public class PaymentMsg extends ChatMsg{

    @Column(name = "payment_id")
    private long paymentId;

    @Column(name = "text")
    private String text;
}
