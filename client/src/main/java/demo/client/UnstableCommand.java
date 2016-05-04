package demo.client;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.apache.commons.lang.math.RandomUtils;

import static java.lang.Thread.sleep;

/**
 * Created by huangyuqiang on 2016/5/3.
 */
public class UnstableCommand extends HystrixCommand<Void> {

    private double failureRate;
    private double timeoutRate;
    private int timeout;

    public UnstableCommand(String group, String threadPool, int timeout, double timeoutRate, double failureRate) {
        super(HystrixCommandGroupKey.Factory.asKey(group), HystrixThreadPoolKey.Factory.asKey(threadPool), timeout);
        this.timeoutRate = timeoutRate;
        this.failureRate = failureRate;
        this.timeout = timeout;
    }

    @Override
    protected Void run() {
        double random = RandomUtils.nextDouble();
        if (random <= timeoutRate) {
            try {
                sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (random <= timeoutRate + failureRate){
            throw new RuntimeException("Failed");
        }
        System.out.println("Success");
        return null;
    }

    @Override
    protected Void getFallback() {
        if (isResponseTimedOut()) {
            System.out.println("Timeout fallback");
            return null;
        }
        if (isFailedExecution()) {
            System.out.println("Failure fallback");
            return null;
        }
        if (isCircuitBreakerOpen()) {
            System.out.println("Circuit Breaker Open fallback");
            return null;
        }
        if (isResponseRejected()) {
            System.out.println("Response Rejected fallback");
            return null;
        }
        System.out.println("Other fallback");
        return null;
    }

}
