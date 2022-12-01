package example.milk.platform.server.userserv;

import example.milk.platform.server.account.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "user_serv")
@Getter
public class UserServ {

    @Column(name = "user_serv_id")
    @Id
    @GeneratedValue
    private long id;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serv_id")
    private Serv serv;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "progress")
    private short progress;

    @OneToOne(fetch = FetchType.LAZY)
    private Chat chat;

    @OneToOne(fetch = FetchType.LAZY)
    private Application application;


    public int changeProgress(short newState) {
        this.progress = newState;
        return 1;
    }
}
