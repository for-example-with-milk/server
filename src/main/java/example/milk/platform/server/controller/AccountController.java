package example.milk.platform.server.controller;

import example.milk.platform.server.account.AccountManager;
import example.milk.platform.server.packet.requestbody.LoginRequestBody;
import example.milk.platform.server.packet.requestbody.SignUpProvRequestBody;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
import example.milk.platform.server.packet.responsebody.LoginResponseBody;
import example.milk.platform.server.packet.responsebody.SignUpResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountManager accountManager;

    @PostMapping("/user/login")
    public LoginResponseBody login(@RequestBody LoginRequestBody request) {
        return accountManager.login(request);
    }

    @PostMapping("/user/signup/user")
    public SignUpResponseBody signUpUser(@RequestBody SignUpUserRequestBody request) {
        return accountManager.signUpServiceUser(request);
    }

    @PostMapping("/user/signup/prov")
    public SignUpResponseBody signUpProv(@RequestBody SignUpProvRequestBody request) {
        return accountManager.signUpServiceProvider(request);
    }
}
