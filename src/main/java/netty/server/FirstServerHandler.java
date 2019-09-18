package netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.command.Command;
import netty.packet.request.LoginRequestPacket;
import netty.packet.response.LoginResponsePacket;
import netty.packet.request.MessageRequestPacket;
import netty.packet.response.MessageResponsePacket;
import netty.packet.Packet;
import netty.packet.PacketCodeC;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstServerHandler
 * @Description 服务端处理类
 * @Author jiangruliang
 * @Date 2019/8/26 16:13
 * @Version 1.0
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    private static Map<Byte, Class<? extends Packet>> map = new HashMap<>();

    static {
        map.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        map.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        map.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        map.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取客户端发送过来的数据
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet packet = PacketCodeC.ourInstance.decode(requestByteBuf);


    }


}
