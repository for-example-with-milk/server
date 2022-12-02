package example.milk.platform.server.packet.requestbody;


import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class ServiceCreateRequestBody {
    private Long id;
    private String name;
    private String icoUrl;
    private String lore;
    private String city;
    private String categoryList;
    private String account;
}
