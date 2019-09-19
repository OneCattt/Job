package netty.server.handle;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.request.LoginRequestPacket;
import netty.packet.response.LoginResponsePacket;
import netty.session.Session;
import netty.util.IDUtil;
import netty.util.SessionUtil;

import java.util.Date;

/**
 * @ClassName LoginRequestHandle
 * @Description 登录请求处理
 * @Author jiangruliang
 * @Date 2019/9/3 15:06
 * @Version 1.0
 */
//加上注解标识，表示该handle是可以多个channel共享的
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE=new LoginRequestHandler();
    private LoginRequestHandler(){

    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println(new Date() + "收到客户端登录请求......");
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        if (valid(loginRequestPacket)) {
            //校验成功
            loginResponsePacket.setSuccess(true);
            String userId = IDUtil.randomUserId();
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


    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
