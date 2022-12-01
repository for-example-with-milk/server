package example.milk.platform.server.packet.requestbody;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpProvRequestBody {
    private String name;
    private String id;
    private String pw;
    private String pw2;
    private String phone_number;
    private String provider_name;
}