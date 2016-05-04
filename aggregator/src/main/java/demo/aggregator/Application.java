package demo.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
@SpringBootApplication
@EnableTurbine
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
