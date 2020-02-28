package netty.client.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.response.ListGroupMembersResponsePacket;

/**
 * @ClassName JoinGroupResponseHandle
 * @Description 加入群聊响应处理
 * @Author jiangruliang
 * @Date 2019/9/18 14:11
 * @Version 1.0
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersResponsePacket listGroupMembersResponsePacket) throws Exception {
        if (listGroupMembersResponsePacket.isSuccess()) {
            System.out.println("群聊:" + listGroupMembersResponsePacket.getGroupId() + "的成员为：" + listGroupMembersResponsePacket.getUserList());
        } else {
            System.err.println("获取群聊：" + listGroupMembersResponsePacket.getGroupId() + "成员失败");
        }

    }
}
