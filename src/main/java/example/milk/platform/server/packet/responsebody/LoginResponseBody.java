package example.milk.platform.server.packet.responsebody;

import lombok.*;

@Getter
@Setter
@Builder
public class LoginResponseBody {
    private int result;
    private String message;
    private String id;

    public LoginResponseBody(int result, String message, String id) {
        this.result = result;
        this.message = message;
        this.id = id;
    }
}
