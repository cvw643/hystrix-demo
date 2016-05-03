package demo.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
