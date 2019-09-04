package netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.impl.MessageResponsePacket;

import java.util.Date;

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
        System.out.println(new Date() + ": 收到服务端的消息: " + messageResponsePacket.getMessage());
    }
}
