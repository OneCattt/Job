package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.protocol.Command;
import netty.protocol.Packet;
import netty.protocol.PacketCodeC;
import netty.protocol.impl.LoginRequestPacket;
import netty.protocol.impl.LoginResponsePacket;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName FirstClientHandler
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/26 16:15
 * @Version 1.0
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * @Author jiangruliang
     * @Description 这个方法会在客户端连接成功后调用
     **/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date()+"：客户端登录开始");
        LoginRequestPacket loginRequestPacket=new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("oneCattt");
        loginRequestPacket.setPassword("pwd");
        //编码
        ByteBuf byteBuf= PacketCodeC.ourInstance.encode(ctx.alloc(),loginRequestPacket);
        ctx.channel().writeAndFlush(byteBuf);
    }
    private static Map<Byte, Class<? extends Packet>> packetTypeMap=new HashMap<>();
    static {
        packetTypeMap.put(Command.LOGIN_REQUEST,LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE,LoginResponsePacket.class);
    }

    /**
     * @Author jiangruliang
     * @Description 获取服务端返回数据
     **/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet=PacketCodeC.ourInstance.decode(byteBuf);
        packetTypeMap.forEach((type,className)->{
            if (type.equals(packet.getCommand())){
                try {
                    className.newInstance().doChannelRead(ctx,packet);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        //获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        //准备数据，指定字符集编码为UTF-8
        byte[] bytes = "你好，江如亮！".getBytes(Charset.forName("UTF-8"));
        //填充数据到Bytebuf
        buffer.writeBytes(bytes);
        return buffer;
    }
}
