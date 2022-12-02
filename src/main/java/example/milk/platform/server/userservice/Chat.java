package example.milk.platform.server.userservice;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
@Getter
public class Chat {

    @Column(name = "chat_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<ChatMsg> chatMsgList = new ArrayList<>();

    @Column(name = "user_service_id")
    private long userServiceId;

    @Column(name = "unread_msg")
    private int unreadMsg;
}
