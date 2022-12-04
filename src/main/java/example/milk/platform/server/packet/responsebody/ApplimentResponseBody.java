package example.milk.platform.server.packet.responsebody;

import lombok.Getter;

@Getter
public class ApplimentResponseBody {
    private int result;
    private String message;

    public ApplimentResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }
}
