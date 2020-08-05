package thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName SpinLock
 * @Description 自旋
 * @Author DSLPOS
 * @Date 2020/3/30 15:19
 * @Version 1.0
 */
public class SpinLock {
    private AtomicReference cas = new AtomicReference();

    public void lock() {
        Thread current = Thread.currentThread();
        //利用CAS
        while (!cas.compareAndSet(null, current)) {

        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
