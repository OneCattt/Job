package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.MessageResponsePacket;

/**
 * @ClassName MessageReponseHandle
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/3 15:23
 * @Version 1.0
 */
public class MessageReponseHandle extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket.getMessage());

    }
}
