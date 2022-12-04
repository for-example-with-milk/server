package example.milk.platform.server.packet.requestbody;


import example.milk.platform.server.service.Service;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCreateRequestBody {
    private Service service;
    private String token;
}
