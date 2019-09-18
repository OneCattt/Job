package netty.packet.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import netty.command.Command;
import netty.packet.Packet;

/**
 * @ClassName MessageRequestPacket
 * @Description 消息请求包装
 * @Author jiangruliang
 * @Date 2019/9/2 14:19
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }

}
