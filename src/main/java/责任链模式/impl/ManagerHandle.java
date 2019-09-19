package 责任链模式.impl;

import 责任链模式.AbstractHandle;

/**
 * @ClassName ManagerHandle
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/9/4 15:31
 * @Version 1.0
 */
public class ManagerHandle extends AbstractHandle {
    @Override
    public void handleFeeRequest( double fee) {
        if (fee<=300){
            System.out.println("经理同意,费用为【"+fee+"】的费用");
        }else {
            if (getSuccessor()!=null){
                getSuccessor().handleFeeRequest(fee);
            }
        }
    }
}
