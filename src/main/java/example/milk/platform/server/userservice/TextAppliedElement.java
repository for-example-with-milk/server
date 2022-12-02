package example.milk.platform.server.userservice;

import lombok.Getter;

import javax.persistence.*;

@Entity
@DiscriminatorValue("T")
@Getter
public class TextAppliedElement extends AppliedElement {

    @Column(name = "text")
    private String text;
}
