package example.milk.platform.server.packet.requestbody;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpUserRequestBody {
    private String name;
    private String id;
    private String pw;
    private String pw2;
    private String phone_number;
    private String address;
    private String tagList;
    private String gender;
    private short age;
}