package demo.client;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Client client;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

//    @Scheduled(fixedDelay = 10)
//    public void execute1() {
//        UnstableCommand command = new UnstableCommand("MyGroup", "MyThreadPool", 1000, 0.2, 0.2);
//        command.queue();
//    }

    @Scheduled(fixedDelay = 10)
    public void command1() {
        client.command1();
    }

    @Scheduled(fixedDelay = 10)
    public void command2() {
        client.command2();
    }

    @Scheduled(fixedDelay = 10)
    public void command3() {
        client.command3();
    }

    @Scheduled(fixedDelay = 10)
    public void command4() {
        client.command4();
    }

}
