package example.milk.platform.server.packet.responsebody;

import lombok.Getter;

@Getter
public class GetProvNameResponseBody {
    private int result;
    private String message;
    private String providerName;

    public GetProvNameResponseBody(int result, String message, String providerName) {
        this.result = result;
        this.message = message;
        this.providerName = providerName;
    }
}
