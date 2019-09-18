package netty.packet.request;

import netty.packet.Packet;

import static netty.command.Command.LOGOUT_REQUEST;

/**
 * @ClassName LogoutRequestPacket
 * @Description 登出请求包装
 * @Author jiangruliang
 * @Date 2019/9/17 16:46
 * @Version 1.0
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
