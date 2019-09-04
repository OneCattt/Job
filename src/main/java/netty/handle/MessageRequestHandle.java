package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.MessageRequestPacket;
import netty.impl.MessageResponsePacket;

import java.util.Date;

/**
 * @ClassName MessageRequestHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/3 15:11
 * @Version 1.0
 */
public class MessageRequestHandle extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
