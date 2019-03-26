package Com.Service.Impl;


import Com.Service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.stereotype.Service;

@Service
public class HystrixServiceImpl implements HystrixService {
    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getLcc() {
        int i = 1/0;
        return "dfsdfdsaf";
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1200")})
    public String test2() {
        try {
            System.out.println("test2 threadName:"+Thread.currentThread().getName());
            Thread.sleep(2000);
            int j = 0;
            for(int i = 0; i<200000 ;i++) {
                j+=i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test2";
    }

    @HystrixCommand(threadPoolKey = "test3",threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "2")
            ,@HystrixProperty(name = "maxQueueSize",value = "2")})
    public String test3() {
        System.out.println("test3 threadName:"+Thread.currentThread().getName());
        return "test3";
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod",threadPoolKey = "test4",threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "2")
            ,@HystrixProperty(name = "maxQueueSize",value = "2")},commandProperties = {@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")})
    public String test4() {
        System.out.println("test4 threadName:"+Thread.currentThread().getName());
        test3();
        return "test4";
    }

    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),@HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "2")})
    public String test5() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test5 threadName:"+Thread.currentThread().getName());
        return "test5";
    }

    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),@HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "2")})
    public String test6() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test6 threadName:"+Thread.currentThread().getName());
        return "test6";
    }

    public String fallbackMethod() {
        System.out.println("fallbackMethod threadName:"+Thread.currentThread().getName());
        return "fallbackMethod";
    }
}
