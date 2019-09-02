package netty.protocol.impl;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import netty.protocol.Command;
import netty.protocol.Packet;

import java.util.Date;

/**
 * @ClassName MessageResponsePacket
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/2 14:20
 * @Version 1.0
 */
@Data
public class MessageResponsePacket extends Packet {
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }

    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
        System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
    }
}
