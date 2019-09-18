package netty.client.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.response.JoinGroupResponsePacket;

/**
 * @ClassName JoinGroupResponseHandle
 * @Description 加入群聊响应处理
 * @Author jiangruliang
 * @Date 2019/9/18 14:11
 * @Version 1.0
 */
public class JoinGroupResponseHandle extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupResponsePacket joinGroupResponsePacket) throws Exception {
        if (joinGroupResponsePacket.isSuccess()){
            System.out.println("加入群聊"+joinGroupResponsePacket.getGroupId()+"成功");
        }else {
            System.err.println("加入群聊"+joinGroupResponsePacket.getGroupId()+"失败");
        }

    }
}
