package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

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
        System.out.println(new Date()+": 客户端写出数据");
        //1.获取数据
        ByteBuf buffer=getByteBuf(ctx);
        //2.写数据
        ctx.channel().writeAndFlush(buffer);

    }

    /**
     * @Author jiangruliang
     * @Description 获取服务端返回数据
     **/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf=(ByteBuf)msg;
        System.out.println(new Date()+"服务端返回数据 -> "+byteBuf.toString(Charset.forName("UTF-8")));
    }



    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
       //获取二进制抽象 ByteBuf
        ByteBuf buffer=ctx.alloc().buffer();
        //准备数据，指定字符集编码为UTF-8
        byte[] bytes="你好，江如亮！".getBytes(Charset.forName("UTF-8"));
        //填充数据到Bytebuf
        buffer.writeBytes(bytes);
        return buffer;
    }
}
