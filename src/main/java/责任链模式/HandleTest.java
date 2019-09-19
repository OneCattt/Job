package 责任链模式;

import 责任链模式.impl.BossHandle;
import 责任链模式.impl.ManagerHandle;

/**
 * @ClassName HandleTest
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/9/4 15:36
 * @Version 1.0
 */
public class HandleTest {
    public static void main(String[] args) {
        AbstractHandle h1=new ManagerHandle();
        AbstractHandle h2=new BossHandle();
        h1.setSuccessor(h2);
        h1.handleFeeRequest(300);
        h1.handleFeeRequest(500);
    }
}
