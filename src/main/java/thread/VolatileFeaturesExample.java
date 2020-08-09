package thread;

/**
 * @ClassName VolatileFeaturesExample
 * @Description TODO
 * @Author DSLPOS
 * @Date 2020/3/24 14:10
 * @Version 1.0
 */
public class VolatileFeaturesExample {
    //   long v1=0L;
//    public synchronized void set(long l){
//        v1=l;
//    }
//    public void getAndIncrement(){
//        long temp=get();
//        temp+=1L;
//        set(temp);
//        System.out.println(v1);
//    }
//    public synchronized long get(){
//        return v1;
//    }

    volatile long v1 = 0L;

    public void set(long l) {
        v1 = l;
    }

    public void getAndIncrement() {
        v1++;
        System.out.println(v1);
    }

    public long get() {
        return v1;
    }

}
