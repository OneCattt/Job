package netty.server.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import netty.packet.Packet;
import netty.packet.PacketCodeC;

import java.util.List;

/**
 * @ClassName PacketCodecHandle
 * @Description 加解码处理
 * @Author jiangruliang
 * @Date 2019/9/19 9:36 PM
 * @Version 1.0
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf,Packet> {
    public static final PacketCodecHandler INSTANCE=new PacketCodecHandler();
    private PacketCodecHandler(){

    }
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> list) throws Exception {
        ByteBuf byteBuf=channelHandlerContext.channel().alloc().ioBuffer();
        PacketCodeC.ourInstance.encode(byteBuf, packet);
        list.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(PacketCodeC.ourInstance.decode(byteBuf));
    }
}
