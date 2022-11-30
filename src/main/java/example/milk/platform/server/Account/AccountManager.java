package example.milk.platform.server.Account;

import example.milk.platform.server.AcountRepository.AccountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Service
@Transactional
@RequiredArgsConstructor
public class AccountManager {

    private final AccountRepository accountRepository;

    public void joinServiceUser(ServiceUser serviceUser) {
        accountRepository.saveServiceUser(serviceUser);
        System.out.println("레포까진왔어");
        return;
    }

    public void joinServiceProvider(ServiceProvider serviceProvider) {
        accountRepository.saveServiceProvider(serviceProvider);
        return;
    }

    public String findProviderNameById(String id) {
        return accountRepository.findProviderNameById(id);
    }
}
