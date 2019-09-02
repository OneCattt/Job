package netty.protocol.impl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import netty.protocol.Command;
import netty.protocol.Packet;
import netty.protocol.PacketCodeC;
import netty.util.LoginUtil;

/**
 * @ClassName LoginRequestPacket
 * @Description 登录请求
 * @Author jiangruliang
 * @Date 2019/8/30 14:37
 * @Version 1.0
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;
    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }

    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        LoginRequestPacket loginRequestPacket=(LoginRequestPacket)packet;
        LoginResponsePacket loginResponsePacket=new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        if (valid(loginRequestPacket)){
            //校验成功
//            LoginUtil.markAsLogin(ctx.channel());
            loginResponsePacket.setSuccess(true);
        }else {
            //校验失败
            loginResponsePacket.setReson("账号或用户名错误");
            loginResponsePacket.setSuccess(false);
        }
        ByteBuf responseByteBuf= PacketCodeC.ourInstance.encode(ctx.alloc(),loginResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

}
