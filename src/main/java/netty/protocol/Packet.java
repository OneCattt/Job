package netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

/**
 * @ClassName Packet
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/30 14:30
 * @Version 1.0
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version=1;

    /**
     * 指令
     */
    public abstract Byte getCommand();

    public abstract void doChannelRead(ChannelHandlerContext ctx,Packet packet);

}
