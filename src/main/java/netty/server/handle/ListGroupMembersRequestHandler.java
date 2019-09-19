package netty.server.handle;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import netty.packet.request.ListGroupMembersRequestPacket;
import netty.packet.response.ListGroupMembersResponsePacket;
import netty.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JoinGroupRequestHandle
 * @Description 加入群聊请求处理
 * @Author jiangruliang
 * @Date 2019/9/18 13:48
 * @Version 1.0
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE=new ListGroupMembersRequestHandler();

    private ListGroupMembersRequestHandler(){

    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket listGroupMembersRequestPacket) throws Exception {
        //1.将当前的channel加入到要请求的channelGroup里面
        List<String> userList = new ArrayList<>();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(listGroupMembersRequestPacket.getGroupId());
        for (Channel channel : channelGroup
        ) {
            userList.add(SessionUtil.getSession(channel).getUserName());

        }
        channelGroup.add(ctx.channel());
        //2.构造加群响应给客户端
        ListGroupMembersResponsePacket listGroupMembersResponsePacket = new ListGroupMembersResponsePacket();
        listGroupMembersResponsePacket.setSuccess(true);
        listGroupMembersResponsePacket.setGroupId(listGroupMembersRequestPacket.getGroupId());
        listGroupMembersResponsePacket.setUserList(userList);
        ctx.channel().writeAndFlush(listGroupMembersResponsePacket);
    }
}
