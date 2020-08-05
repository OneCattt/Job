package thread;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DSLPOS
 * @Date 2020/3/24 14:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // long v2=0L;
        VolatileFeaturesExample volatileFeaturesExample = new VolatileFeaturesExample();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(volatileFeaturesExample::getAndIncrement);
            thread.start();
        }
        //获取线程数
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        int totalThread = threadGroup.activeCount();
        System.out.println(totalThread + "个");
    }
}
