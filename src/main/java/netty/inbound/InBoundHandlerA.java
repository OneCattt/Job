package netty.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName InBoundHandlerA
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/9/3 14:25
 * @Version 1.0
 */
public class InBoundHandlerA extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerA:" + msg);
        //ctx.pipeline().remove("inBoundHandlerB");
        super.channelRead(ctx, msg);
    }
}
