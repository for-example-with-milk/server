package example.milk.platform.server.AcountRepository;

import example.milk.platform.server.Account.ServiceProvider;
import example.milk.platform.server.Account.ServiceUser;
import example.milk.platform.server.Account.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AccountRepositroy {

    User saveServiceUser(ServiceUser serviceUser);

    User saveServiceProvider(ServiceProvider serviceProvider);

    String findProviderNameById(String id);
}
