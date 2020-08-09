package executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ExecutorTest
 * @Description TODO
 * @Author DSLPOS
 * @Date 2020/2/28 11:30
 * @Version 1.0
 */
public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor executor = buildThreadPoolTaskExecutor();
        executor.execute(() -> sayHi("execute"));
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("=====================================");
        Future<?> submit = executor.submit(() -> sayHi("submit"));
        try {
            submit.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void sayHi(String name) {
        String printStr = "[thread-name:" + Thread.currentThread().getName() + ",执行方式：" + name + "]";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",我异常了");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("onecattt");
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
