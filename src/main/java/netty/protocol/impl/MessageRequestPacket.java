package netty.protocol.impl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import netty.protocol.Command;
import netty.protocol.Packet;
import netty.protocol.PacketCodeC;

import java.util.Date;

/**
 * @ClassName MessageRequestPacket
 * @Description TODO
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

    @Override
    public void doChannelRead(ChannelHandlerContext ctx, Packet packet) {
        MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        ByteBuf responseByteBuf = PacketCodeC.ourInstance.encode(ctx.alloc(), messageResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }
}
