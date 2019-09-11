package netty.impl;

import lombok.Data;
import netty.Command;
import netty.packet.Packet;

/**
 * @ClassName MessageResponsePacket
 * @Description 消息响应包装类
 * @Author jiangruliang
 * @Date 2019/9/2 14:20
 * @Version 1.0
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;
    private String fromUserName;
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }

}
