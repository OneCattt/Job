package netty.client.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.response.LogoutResponsePacket;
import netty.util.SessionUtil;

/**
 * @ClassName LoginResponseHandle
 * @Description 登录响应处理
 * @Author jiangruliang
 * @Date 2019/9/3 15:19
 * @Version 1.0
 */
public class LogoutResponseHandle extends SimpleChannelInboundHandler<LogoutResponsePacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket logoutResponsePacket) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }
}
