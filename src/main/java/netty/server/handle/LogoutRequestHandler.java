package netty.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.request.LogoutRequestPacket;
import netty.packet.response.LogoutResponsePacket;
import netty.util.SessionUtil;

/**
 * @ClassName LogoutRequestHandler
 * @Description 登出请求处理
 * @Author jiangruliang
 * @Date 2019/9/17 16:56
 * @Version 1.0
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LogoutRequestPacket logoutRequestPacket) throws Exception {
        SessionUtil.unBindSession(channelHandlerContext.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        channelHandlerContext.channel().writeAndFlush(logoutResponsePacket);
    }
}
