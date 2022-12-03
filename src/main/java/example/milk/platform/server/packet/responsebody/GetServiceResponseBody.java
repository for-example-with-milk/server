package example.milk.platform.server.packet.responsebody;

import example.milk.platform.server.service.Service;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class GetServiceResponseBody {
    private int result;
    private String message;
    private Service service;

    public GetServiceResponseBody(int result, String message, Service service) {
        this.result = result;
        this.message = message;
        this.service = service;
    }
}
