package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.LoginRequestPacket;
import netty.impl.LoginResponsePacket;
import netty.util.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName LoginResponseHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/3 15:19
 * @Version 1.0
 */
public class LoginResponseHandle extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("oneCattt");
        loginRequestPacket.setPassword("pwd");
        //编码
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.getSuccess()) {
            System.out.println(new Date() + "客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + "客户端登录失败，原因：" + loginResponsePacket.getReson());
        }
    }
}
