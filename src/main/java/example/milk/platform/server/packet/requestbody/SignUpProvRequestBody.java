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
    private String phoneNumber;
    private String providerName;
}