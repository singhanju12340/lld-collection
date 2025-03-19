package interview.TestApplication;

import com.machineCode.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anju
 * @created on 19/03/25 and 3:45 PM
 */

@SpringBootApplication
public class TestLauncher {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
