package netty.protocol.impl;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import netty.protocol.Command;
import netty.protocol.Packet;

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

    }
}
