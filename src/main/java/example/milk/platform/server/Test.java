package example.milk.platform.server;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="test")
public class Test {
    @Id
    private int id;

    @Column
    private String str;
}