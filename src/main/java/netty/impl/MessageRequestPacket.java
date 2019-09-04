package netty.impl;

import lombok.Data;
import netty.Command;
import netty.packet.Packet;

/**
 * @ClassName MessageRequestPacket
 * @Description 消息请求包装
 * @Author TOPFEEL
 * @Date 2019/9/2 14:19
 * @Version 1.0
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }

}
