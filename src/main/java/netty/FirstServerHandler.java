package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @ClassName FirstServerHandler
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/8/26 16:13
 * @Version 1.0
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取客户端发送过来的数据
        ByteBuf byteBuf=(ByteBuf)msg;
        System.out.println(new Date()+"服务器端读取到数据 ->"+byteBuf.toString(Charset.forName("UTF-8")));
        //回复数据到客户端
        System.out.println(new Date()+":从服务端返回数据");
        ByteBuf byteBuf1=getByteBuf(ctx);
        ctx.channel().writeAndFlush(byteBuf1);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        //获取二进制抽象 ByteBuf
        ByteBuf buffer=ctx.alloc().buffer();
        //准备数据，指定字符集编码为UTF-8
        byte[] bytes="你好，我拿到数据了！".getBytes(Charset.forName("UTF-8"));
        //填充数据到Bytebuf
        buffer.writeBytes(bytes);
        return buffer;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务端向客户端主动发送数据");
        ByteBuf byteBuf=getByteBuf(ctx);
        ctx.channel().writeAndFlush(byteBuf);
    }
}
