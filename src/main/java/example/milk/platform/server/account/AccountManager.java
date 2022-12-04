package example.milk.platform.server.account;

import example.milk.platform.server.packet.requestbody.*;
import example.milk.platform.server.packet.responsebody.GetNameResponseBody;
import example.milk.platform.server.packet.responsebody.GetProvNameResponseBody;
import example.milk.platform.server.packet.responsebody.LoginResponseBody;
import example.milk.platform.server.repository.AccountRepository;
import example.milk.platform.server.packet.responsebody.SignUpResponseBody;
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

    public SignUpResponseBody signUpServiceUser(SignUpUserRequestBody request) {
        boolean exist = accountRepository.existUserById(request.getId());

        try {
            if (exist)
                return new SignUpResponseBody(1, "중복된 아이디를 가진 계정이 있습니다.");
            if (request.getPw().compareTo(request.getPw2()) != 0)
                return new SignUpResponseBody(1, "비밀번호 확인이 틀렸습니다.");
            if (!accountRepository.signUpUser(request))
                return new SignUpResponseBody(2, "회원가입에 실패했습니다.");
        } catch (Exception e) {
            return new SignUpResponseBody(2, "회원가입에 실패했습니다.");
        }

        return new SignUpResponseBody(0, "");
    }

    public SignUpResponseBody signUpServiceProvider(SignUpProvRequestBody request) {
        boolean exist = accountRepository.existUserById(request.getId());

        try {
            if (exist)
                return new SignUpResponseBody(1, "중복된 아이디를 가진 계정이 있습니다.");
            if (request.getPw().compareTo(request.getPw2()) != 0)
                return new SignUpResponseBody(1, "비밀번호 확인이 틀렸습니다.");
            if (!accountRepository.signUpProvider(request))
                return new SignUpResponseBody(2, "회원가입에 실패했습니다.");
        } catch (Exception e) {
            return new SignUpResponseBody(2, "회원가입에 실패했습니다.");
        }

        return new SignUpResponseBody(0, "");
    }

    public LoginResponseBody login(LoginRequestBody request) {
        try {
            ServiceUser user = accountRepository.matchAccountUser(request.getId(), request.getPw());
            ServiceProvider provider = accountRepository.matchAccountProvider(request.getId(), request.getPw());

            if (user != null)
                return new LoginResponseBody(0, "", request.getId(), user.getName(), true);
            if (provider != null)
                return new LoginResponseBody(0, "", request.getId(), provider.getName(), false);
            return new LoginResponseBody(1, "존재하지 않는 계정이거나 비밀번호가 틀렸습니다.", "", "", false);
        } catch (Exception e) {
            return new LoginResponseBody(2, "로그인에 실패했습니다.", "", "", false);
        }
    }

    public GetNameResponseBody getName(GetNameRequestBody request) {
        String name = accountRepository.getNameById(request.getToken());

        if (name == null)
            return new GetNameResponseBody(1, "존재하지 않는 계정입니다.", "");

        return new GetNameResponseBody(0, "", name);
    }

    public GetProvNameResponseBody getProvName(GetProvNameRequestBody request) {
        String providerName = accountRepository.getProvNameById(request.getToken());

        if (providerName == null)
            return new GetProvNameResponseBody(1, "존재하지 않는 계정입니다.", "");

        return new GetProvNameResponseBody(0, "", providerName);
    }
}
