package demo.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
