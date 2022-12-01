package example.milk.platform.server.account;

public abstract class User {
    protected String id;
    protected String pw;
    protected String name;
    protected String phoneNum;

    public User(String id, String pw, String name, String phone) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phoneNum = phone;
    }
}
