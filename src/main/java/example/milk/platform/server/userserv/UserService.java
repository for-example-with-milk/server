package example.milk.platform.server.userserv;

import example.milk.platform.server.account.User;
import example.milk.platform.server.service.Service;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "user_service")
@Getter
public class UserService {

    @Column(name = "user_service_id")
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

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
