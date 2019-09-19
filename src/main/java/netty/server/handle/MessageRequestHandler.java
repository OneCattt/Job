package netty.server.handle;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.request.MessageRequestPacket;
import netty.packet.response.MessageResponsePacket;
import netty.session.Session;
import netty.util.SessionUtil;

/**
 * @ClassName MessageRequestHandle
 * @Description 消息请求处理
 * @Author jiangruliang
 * @Date 2019/9/3 15:11
 * @Version 1.0
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE=new MessageRequestHandler();

    private MessageRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());
        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());
        // 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        // 4.将消息发送给消息接收方
        if (toUserChannel != null) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + messageRequestPacket.getToUserId() + "]不在线，发送失败");
        }


    }
}
