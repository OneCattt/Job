package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.protocol.Command;
import netty.protocol.Packet;
import netty.protocol.PacketCodeC;
import netty.protocol.impl.LoginRequestPacket;
import netty.protocol.impl.LoginResponsePacket;
import netty.protocol.impl.MessageRequestPacket;
import netty.protocol.impl.MessageResponsePacket;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstServerHandler
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/8/26 16:13
 * @Version 1.0
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    private static Map<Byte,Class<? extends Packet>> map=new HashMap<>();
    static {
        map.put(Command.LOGIN_REQUEST,LoginRequestPacket.class);
        map.put(Command.LOGIN_RESPONSE,LoginResponsePacket.class);
        map.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        map.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取客户端发送过来的数据
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet packet= PacketCodeC.ourInstance.decode(requestByteBuf);
            map.forEach((type,className)->{
                if (type.equals(packet.getCommand())){
                    try {
                        className.newInstance().doChannelRead(ctx,packet);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });

    }


}
