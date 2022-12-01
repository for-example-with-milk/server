package example.milk.platform.server.packet.requestbody;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestBody {
    private String id;
    private String pw;
}
