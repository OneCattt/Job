package netty.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.packet.Packet;

import java.util.HashMap;
import java.util.Map;

import static netty.command.Command.*;

/**
 * @ClassName ImHandler
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/9/19 9:54 PM
 * @Version 1.0
 */
public class ImHandler extends SimpleChannelInboundHandler<Packet> {
    public static final ImHandler INSTANCE=new ImHandler();
    private Map<Byte,SimpleChannelInboundHandler<? extends Packet>> handlerMap;
    private ImHandler(){
        handlerMap=new HashMap<>();
        handlerMap.put(MESSAGE_REQUEST,MessageRequestHandler.INSTANCE);
        handlerMap.put(CREATE_GROUP_REQUEST, CreateGroupRequestHandler.INSTANCE);
        handlerMap.put(JOIN_GROUP_REQUEST, JoinGroupRequestHandler.INSTANCE);
        handlerMap.put(LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestHandler.INSTANCE);
        handlerMap.put(LOGOUT_REQUEST, LogoutRequestHandler.INSTANCE);
    }
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {
        handlerMap.get(packet.getCommand()).channelRead(channelHandlerContext,packet);
    }
}
