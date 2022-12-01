package example.milk.platform.server.packet.responsebody;

import lombok.*;

@Getter
@Setter
@Builder
public class SignUpResponseBody {
    private int result;
    private String message;

    public SignUpResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }
}
