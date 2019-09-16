package 责任链模式.impl;

import 责任链模式.AbstractHandle;

/**
 * @ClassName BossHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/4 15:35
 * @Version 1.0
 */
public class BossHandle extends AbstractHandle {
    @Override
    public void handleFeeRequest(double fee) {
        System.out.println("总监同意,费用为【"+fee+"】的费用");
    }
}
