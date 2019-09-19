package netty.packet.response;

import lombok.Data;
import netty.command.Command;
import netty.packet.Packet;

import java.util.List;

/**
 * @ClassName CreateGroupRequestPacket
 * @Description 创建群聊响应包装
 * @Author jiangruliang
 * @Date 2019/9/17 16:26
 * @Version 1.0
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
