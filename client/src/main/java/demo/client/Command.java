package demo.client;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.commons.lang.math.RandomUtils;

import static java.lang.Thread.sleep;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
public class Command extends HystrixCommand<String> {

    private int timeout;

    /**
     * @param timeout Milliseconds
     */
    public Command(int timeout) {
        super(HystrixCommandGroupKey.Factory.asKey("Greeting"), timeout);
        this.timeout = timeout;
    }

    @Override
    protected String run() throws Exception {
        sleep(RandomUtils.nextInt(timeout * 2));
        return "Hello";
    }

    @Override
    protected String getFallback() {
        return "Sorry";
    }
}
