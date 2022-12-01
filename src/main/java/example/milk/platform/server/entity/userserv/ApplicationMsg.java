package example.milk.platform.server.entity.userserv;


import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class ApplicationMsg extends ChatMsg {

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "text")
    private String text;
}
