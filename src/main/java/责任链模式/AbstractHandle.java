package 责任链模式;

/**
 * @ClassName AbstractHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/4 15:19
 * @Version 1.0
 */
public abstract class AbstractHandle {
    /**
     * 持有下一个处理请求的对象
     */
    protected AbstractHandle successor = null;

    /**
     *设置下一个处理请求的对象
     */
    public void setSuccessor(AbstractHandle successor) {
        this.successor = successor;
    }

    /**
     * 取值方法
     */
    public AbstractHandle getSuccessor(){
        return successor;
    }

    /**
     *
     * @param fee 费用
     */
    public abstract void handleFeeRequest(double fee);
}
