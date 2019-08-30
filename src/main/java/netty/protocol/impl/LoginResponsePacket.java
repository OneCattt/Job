package netty.protocol.impl;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import netty.protocol.Command;
import netty.protocol.Packet;

import java.util.Date;

/**
 * @ClassName LoginRequestPacket
 * @Description 登录请求
 * @Author jiangruliang
 * @Date 2019/8/30 14:37
 * @Version 1.0
 */
@Data
public class LoginResponsePacket extends Packet{
    private Boolean success;

    private String  reson;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }

    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        LoginResponsePacket loginResponsePacket=(LoginResponsePacket)packet;
        if (loginResponsePacket.getSuccess()){
            System.out.println(new Date()+"客户端登录成功");
        }else {
            System.out.println(new Date()+"客户端登录失败，原因："+loginResponsePacket.getReson());
        }
    }
}
