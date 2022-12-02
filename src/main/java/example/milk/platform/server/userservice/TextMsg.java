package example.milk.platform.server.userservice;

import javax.persistence.*;

@Entity
@DiscriminatorValue("T")
public class TextMsg extends ChatMsg {

    @Column(name = "text")
    private String text;
}
