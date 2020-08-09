package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AQSDebug
 * @Description TODO
 * @Author DSLPOS
 * @Date 2020/4/8 17:07
 * @Version 1.0
 */
public class AQSDebug {
    private Lock lock = new ReentrantLock();

    private void sayHello() {
        lock.lock();
        System.out.println("hello");
        lock.unlock();
    }

    public static void main(String[] args) {
        AQSDebug aqsDebug = new AQSDebug();
        new Thread(aqsDebug::sayHello, "first").start();
        new Thread(aqsDebug::sayHello, "second").start();
        new Thread(aqsDebug::sayHello, "third").start();
    }
}
