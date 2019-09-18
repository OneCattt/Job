package netty.server.handle;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import netty.packet.request.CreateGroupRequestPacket;
import netty.packet.response.CreateGroupResponsePacket;
import netty.util.IDUtil;
import netty.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CreateGroupRequestHandler
 * @Description 创建群聊请求处理
 * @Author jiangruliang
 * @Date 2019/9/17 17:14
 * @Version 1.0
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();
        List<String> userNameList = new ArrayList<>();
        //1.创建一个channel分组
        ChannelGroup channelGroup=new DefaultChannelGroup(ctx.executor());
        //2.筛选出待加入群聊的用户的channel和userName
        for (String userId:userIdList
             ) {
            Channel channel= SessionUtil.getChannel(userId);
            if (channel!=null){
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }
        // 3. 创建群聊创建结果的响应
        CreateGroupResponsePacket createGroupResponsePacket=new CreateGroupResponsePacket();
        createGroupResponsePacket.setGroupId(IDUtil.randomId());
        createGroupResponsePacket.setUserNameList(userNameList);
        createGroupResponsePacket.setSuccess(true);
        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
    }
}
