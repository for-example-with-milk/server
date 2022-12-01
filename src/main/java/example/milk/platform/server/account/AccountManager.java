package example.milk.platform.server.account;

import example.milk.platform.server.acountRepository.AccountRepository;
import example.milk.platform.server.packet.requestbody.SignUpUserRequestBody;
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
        }
        catch (Exception e) {
            return new SignUpResponseBody(2, "회원가입에 실패했습니다.");
        }

        return new SignUpResponseBody(0, "");
    }
}
