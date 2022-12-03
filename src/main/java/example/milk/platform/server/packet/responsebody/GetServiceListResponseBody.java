package example.milk.platform.server.packet.responsebody;

import example.milk.platform.server.service.Service;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetServiceListResponseBody {
    private int result;
    private String message;
    private List<Service> serviceList;

    public GetServiceListResponseBody(int result, String message, List<Service> serviceList) {
        this.result = result;
        this.message = message;
        this.serviceList = serviceList;
    }
}
