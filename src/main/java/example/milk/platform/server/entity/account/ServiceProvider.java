package example.milk.platform.server.entity.account;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("provider")
public class ServiceProvider extends User{

    @Column(name = "providerName")
    private String providerName;

    protected ServiceProvider() {}

    public ServiceProvider(String id, String pw, String name, String phone, String providerName) {
        super(id, pw, name, phone);

        this.providerName = providerName;
    }
}
