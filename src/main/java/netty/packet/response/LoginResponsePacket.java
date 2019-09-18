package netty.packet.response;

import lombok.Data;
import netty.command.Command;
import netty.packet.Packet;

/**
 * @ClassName LoginRequestPacket
 * @Description 登录响应包装
 * @Author jiangruliang
 * @Date 2019/8/30 14:37
 * @Version 1.0
 */
@Data
public class LoginResponsePacket extends Packet {
    private Boolean success;

    private String reson;

    private String userId;

    private String userName;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }


}
