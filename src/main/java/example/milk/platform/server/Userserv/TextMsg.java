package example.milk.platform.server.Userserv;

import javax.persistence.*;

@Entity
@DiscriminatorValue("T")
public class TextMsg extends ChatMsg {

    @Column(name = "text")
    private String text;
}
