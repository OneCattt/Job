package netty.packet.response;

import lombok.Data;
import netty.command.Command;
import netty.packet.Packet;

import java.util.List;

/**
 * @ClassName CreateGroupRequestPacket
 * @Description 创建群聊请求
 * @Author jiangruliang
 * @Date 2019/9/17 16:26
 * @Version 1.0
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private List<String> userList;

    private boolean success;

    private String groupId;
    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
