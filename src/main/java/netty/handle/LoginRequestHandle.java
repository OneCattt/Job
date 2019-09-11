package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.LoginRequestPacket;
import netty.impl.LoginResponsePacket;
import netty.session.Session;
import netty.util.SessionUtil;

import java.util.Date;
import java.util.UUID;

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
        System.out.println(new Date() + "收到客户端登录请求......");
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            //校验成功
            loginResponsePacket.setSuccess(true);
            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            loginResponsePacket.setUserName(loginRequestPacket.getUsername());
            System.out.println("[" + loginRequestPacket.getUsername() + "]登录成功");
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
        } else {
            //校验失败
            loginResponsePacket.setReson("账号或用户名错误");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + "登录失败！");
        }
        //登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
