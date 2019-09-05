package netty.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ClassName PacketEncoder
 * @Description
 * @Author jiangruliang
 * @Date 2019/9/3 15:13
 * @Version 1.0
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCodeC.ourInstance.encode(byteBuf, packet);
    }
}
