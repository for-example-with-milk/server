package example.milk.platform.server.packet.responsebody;

import lombok.*;

@Getter
@Setter
@Builder
public class LoginResponseBody {
    private int result;
    private String message;
    private String id;
    private String name;
    private boolean isUser;

    public LoginResponseBody(int result, String message, String id, String name, boolean isUser) {
        this.result = result;
        this.message = message;
        this.id = id;
        this.name = name;
        this.isUser = isUser;
    }
}
