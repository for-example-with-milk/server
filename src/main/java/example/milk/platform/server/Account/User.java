package example.milk.platform.server.Account;

import lombok.Getter;

import javax.persistence.*;
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter
public class User {

    @Id
    @Column(name = "user_id")
    protected String id;

    @Column(name = "pw")
    private String pw;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_num")
    private String phone_num;

    protected User() {}

    public User(String id, String pw, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone_num = phone;
    }
}
