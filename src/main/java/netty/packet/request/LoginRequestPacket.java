package netty.packet.request;

import lombok.Data;
import netty.command.Command;
import netty.packet.Packet;

/**
 * @ClassName LoginRequestPacket
 * @Description 登录请求包装类
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


}
