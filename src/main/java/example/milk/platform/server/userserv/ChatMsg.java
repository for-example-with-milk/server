package example.milk.platform.server.userserv;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_msg")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
public class ChatMsg {

    @Column(name = "chat_msg_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "chat_id")
//    private long chat_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat")
    private Chat chat;

    @Column(name = "user_id")
    private long senderId;

    private LocalDateTime time;

    @Column(name = "text")
    private String text;

}
