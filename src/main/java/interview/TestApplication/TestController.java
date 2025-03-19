package interview.TestApplication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anju
 * @created on 19/03/25 and 3:45 PM
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {


    @GetMapping("/hello")
    public String helloTest(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello test %s!", name);
    }
}
