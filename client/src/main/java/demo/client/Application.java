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

    @Scheduled(fixedDelay = 10)
    public void execute() {
        UnstableCommand command = new UnstableCommand("MyGroup", "MyThreadPool", 1000, 0.2, 0.2);
        command.queue();
    }
}
