package example.milk.platform.server.entity.account;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("provider")
public class ServiceProvider extends User{

    @Column(name = "provider_name")
    private String provider_name;

    protected ServiceProvider() {}

    public ServiceProvider(String id, String pw, String name, String phone, String providerName) {
        super(id, pw, name, phone);

        this.provider_name = providerName;
    }
}
