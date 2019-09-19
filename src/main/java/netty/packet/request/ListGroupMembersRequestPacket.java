package netty.packet.request;

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
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_REQUEST;
    }
}
