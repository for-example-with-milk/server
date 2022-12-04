package example.milk.platform.server.packet.responsebody;

import lombok.Getter;

@Getter
public class CreateSubServiceResponseBody {
    private int result;
    private String message;

    public CreateSubServiceResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }
}
