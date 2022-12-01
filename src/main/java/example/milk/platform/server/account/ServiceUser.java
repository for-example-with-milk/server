package example.milk.platform.server.account;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@DiscriminatorValue("user")
public class ServiceUser extends User{

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private short age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "tag_list")
    private String tagList;

    protected ServiceUser() {}

    public ServiceUser(String id, String pw, String name, String phone, String addr, short age, String gender, String tagList) {
        super(id, pw, name, phone);

        this.address = addr;
        this.age = age;
        this.gender = Gender.valueOf(gender);
        this.tagList = tagList;
    }
}
