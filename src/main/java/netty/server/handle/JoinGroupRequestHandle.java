package netty.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import netty.packet.request.JoinGroupRequestPacket;
import netty.packet.response.JoinGroupResponsePacket;
import netty.util.SessionUtil;

/**
 * @ClassName JoinGroupRequestHandle
 * @Description 加入群聊请求处理
 * @Author jiangruliang
 * @Date 2019/9/18 13:48
 * @Version 1.0
 */
public class JoinGroupRequestHandle extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket joinGroupRequestPacket) throws Exception {
        //1.将当前的channel加入到要请求的channelGroup里面
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(joinGroupRequestPacket.getGroupId());
        channelGroup.add(ctx.channel());
        //2.构造加群响应给客户端
        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setSuccess(true);
        joinGroupResponsePacket.setGroupId(joinGroupRequestPacket.getGroupId());
        ctx.channel().writeAndFlush(joinGroupResponsePacket);
    }
}
