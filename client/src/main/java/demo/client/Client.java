package demo.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * Created by huangyuqiang on 2016/5/4.
 */
@Service
public class Client {

    @HystrixCommand(fallbackMethod = "fallback")
    public void command1() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            System.out.println("command2 succeed");
            return;
        }
        System.out.println("command1 succeed");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public void command2() {
        try {
            sleep(500);
        } catch (InterruptedException e) {
            System.out.println("command2 interrupted");
            return;
        }
        System.out.println("command2 succeed");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public void command3() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("command3 interrupted");
            return;
        }
        System.out.println("command3 succeed");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public void command4() {
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("command4 interrupted");
            return;
        }
        System.out.println("command4 succeed");
    }

    private void fallback() {
        System.out.println("fallback");
    }
}
