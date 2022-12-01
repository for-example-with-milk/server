package example.milk.platform.server.packet.responsebody;

import lombok.Getter;

@Getter
public class GetNameResponseBody {
    private int result;
    private String message;
    private String name;

    public GetNameResponseBody(int result, String message, String name) {
        this.result = result;
        this.message = message;
        this.name = name;
    }
}
