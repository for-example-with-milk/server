package example.milk.platform.server.entity.userserv;

import lombok.Getter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("P")
@Getter
public class ProdAppliedElement extends AppliedElement {

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private int price;

    @Column(name = "prod_num")
    private int num;
}
