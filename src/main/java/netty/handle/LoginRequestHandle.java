package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.LoginRequestPacket;
import netty.impl.LoginResponsePacket;

/**
 * @ClassName LoginRequestHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/3 15:06
 * @Version 1.0
 */
public class LoginRequestHandle extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            //校验成功
            loginResponsePacket.setSuccess(true);
        } else {
            //校验失败
            loginResponsePacket.setReson("账号或用户名错误");
            loginResponsePacket.setSuccess(false);
        }
        ctx.channel().writeAndFlush(loginResponsePacket);
    }


    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
