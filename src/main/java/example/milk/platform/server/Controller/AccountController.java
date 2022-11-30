package example.milk.platform.server.Controller;

import example.milk.platform.server.Account.AccountManager;
import example.milk.platform.server.Account.ServiceProvider;
import example.milk.platform.server.Account.ServiceUser;
import example.milk.platform.server.Account.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountManager accountManager;

    @GetMapping("/user")
    public String joinServiceUser() {
        ServiceUser serviceUser = new ServiceUser("usr", "pw", "kim", "010",
                "daegu", (short) 20, "FEMALE", "운동,홈트");

        accountManager.joinServiceUser(serviceUser);
        System.out.println("user 생성");

        return "redirect:/";
    }

    @GetMapping("/provider")
    public String joinServiceProvider() {
        ServiceProvider serviceProvider = new ServiceProvider("prov", "pw", "kim", "010",
                "mail");

        accountManager.joinServiceProvider(serviceProvider);
        System.out.println("provider 생성");

        return "redirect:/";
    }

    @GetMapping("/search/provider")
    public String getProviderName() {
        String providerName = accountManager.findProviderNameById("id");
        System.out.println(providerName);

        return "redirect:/";
    }
}
