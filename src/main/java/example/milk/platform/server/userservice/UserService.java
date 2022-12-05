package example.milk.platform.server.userservice;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;

    @JsonBackReference
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

    public UserService(Service service, User user, short progress, Chat chat, Appliment appliment) {
        this.service = service;
        this.user = user;
        this.progress = progress;
        this.chat = chat;
    }

    public int changeProgress(short newState) {
        this.progress = newState;
        return 1;
    }

    public void setService(Service service) {
        this.service = service;
        service.setUserService(this);
    }

    public void setAppliment(Appliment appliment) {
        this.appliment = appliment;
    }
}