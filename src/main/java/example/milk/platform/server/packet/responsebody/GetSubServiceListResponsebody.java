package example.milk.platform.server.packet.responsebody;

import example.milk.platform.server.service.Service;
import example.milk.platform.server.service.subservice.SubService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetSubServiceListResponsebody {

    private Service service;
    private int result;
    private String message;
    private List<SubService> subServiceList;

    public GetSubServiceListResponsebody(Service service, int result, String message, List<SubService> subServiceList) {
        this.service = service;
        this.result = result;
        this.message = message;
        this.subServiceList = subServiceList;
    }
}
