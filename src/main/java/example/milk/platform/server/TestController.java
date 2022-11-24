package example.milk.platform.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {
    @Autowired
    TestRepository testRepository;

    @GetMapping("/test")
    public String test() {
        Optional<Test> result = testRepository.findById(1);
        if (result.isPresent()) {
            Test test = result.get();
            return test.getStr();
        }
        return "Failed";
    }
}