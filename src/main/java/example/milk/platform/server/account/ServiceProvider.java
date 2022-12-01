package example.milk.platform.server.account;

public class ServiceProvider extends User {
    private String providerName;

    public ServiceProvider(String id, String pw, String name, String phone, String providerName) {
        super(id, pw, name, phone);

        this.providerName = providerName;
    }

    public example.milk.platform.server.entity.account.ServiceProvider toEntity() {
        return new example.milk.platform.server.entity.account.ServiceProvider(
                id, pw, name, phoneNum, providerName
        );
    }
}
