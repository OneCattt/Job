package netty.packet.response;

import lombok.Data;
import netty.command.Command;
import netty.packet.Packet;

/**
 * @ClassName CreateGroupRequestPacket
 * @Description 创建群聊请求
 * @Author jiangruliang
 * @Date 2019/9/17 16:26
 * @Version 1.0
 */
@Data
public class JoinGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;
    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
