package example.milk.platform.server.account;

import lombok.Getter;
import lombok.Setter;

public class ServiceUser extends User {
    private String address;
    private short age;
    private String gender;
    private String tagList;

    public ServiceUser(String id, String pw, String name, String phone, String address, short age, String gender, String tagList) {
        super(id, pw, name, phone);
        this.address = address;
        this.gender = gender;
        this.tagList = tagList;
        this.age = age;
    }

    public example.milk.platform.server.entity.account.ServiceUser toEntity() {
        return new example.milk.platform.server.entity.account.ServiceUser(
                id, pw, name, phoneNum, address, age, gender, tagList
        );
    }
}