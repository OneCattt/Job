package netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import netty.packet.PacketCodeC;

import java.util.List;

/**
 * @ClassName PacketDecoder
 * @Description 包装加码类
 * @Author jiangruliang
 * @Date 2019/9/3 15:03
 * @Version 1.0
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(PacketCodeC.ourInstance.decode(byteBuf));
    }
}
