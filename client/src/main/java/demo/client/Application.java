package demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
@SpringCloudApplication
@EnableScheduling
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }


    @Scheduled(fixedDelay = 100)
    public void run() {
        Command command = new Command(100);
        System.out.println(command.execute());
    }
}
