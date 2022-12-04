package example.milk.platform.server.packet.requestbody;

import example.milk.platform.server.account.User;
import example.milk.platform.server.userservice.AppliedElement;
import example.milk.platform.server.userservice.Appliment;
import example.milk.platform.server.userservice.Checkedbox;
import example.milk.platform.server.userservice.Payment;
import lombok.Getter;

import java.util.List;

@Getter
public class ApplimentRequestBody {
    private String token;
    private Long subServiceId;
    private Appliment appliment;
    private Payment payment;
    private List<AppliedElement> appliedElementList;
    private List<List<Checkedbox>> checkedboxLists;

    public ApplimentRequestBody(String token, Long subServiceId, Appliment appliment, Payment payment, List<AppliedElement> appliedElementList, List<List<Checkedbox>> checkedboxLists) {
        this.token = token;
        this.subServiceId = subServiceId;
        this.appliment = appliment;
        this.payment = payment;
        this.appliedElementList = appliedElementList;
        this.checkedboxLists = checkedboxLists;
    }
}
