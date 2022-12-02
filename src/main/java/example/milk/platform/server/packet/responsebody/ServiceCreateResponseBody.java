package example.milk.platform.server.packet.responsebody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ServiceCreateResponseBody {
    private int result;
    private String message;

    public ServiceCreateResponseBody(int result, String message) {
        this.result = result;
        this.message = message;
    }
}
