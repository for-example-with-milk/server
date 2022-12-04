package example.milk.platform.server.packet.requestbody;

import lombok.Getter;

@Getter
public class GetServiceListRequestBody {
    private String tag;
    private String city;
    private String token;
}
