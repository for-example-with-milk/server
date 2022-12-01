package example.milk.platform.server.entity.userserv;

import javax.persistence.*;

@Entity
@DiscriminatorValue("T")
public class TextMsg extends ChatMsg {

    @Column(name = "text")
    private String text;
}
