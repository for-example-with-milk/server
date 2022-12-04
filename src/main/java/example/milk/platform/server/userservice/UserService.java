package example.milk.platform.server.userservice;

import example.milk.platform.server.account.User;
import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.ServiceManager;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "user_service")
@Getter
public class UserService {

    @Column(name = "user_service_id")
    @Id
    @GeneratedValue
    private Long id;

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
    private Appliment appliment;

    //==Method==//
    protected UserService() {

    }

    public UserService(Long id, Service service, User user, short progress, Chat chat, Appliment appliment) {
        this.id = id;
        this.service = service;
        this.user = user;
        this.progress = progress;
        this.chat = chat;
        this.appliment = appliment;
    }

    public int changeProgress(short newState) {
        this.progress = newState;
        return 1;
    }
}