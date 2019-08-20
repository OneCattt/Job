package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;

/**
 * @ClassName NettyClient
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/20 14:48
 * @Version 1.0
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap=new Bootstrap();
        NioEventLoopGroup group=new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) {
                        channel.pipeline().addLast(new StringDecoder());
                    }
                });
        Channel channel=bootstrap.connect("127.0.0.1",8000).channel();
        while (true){
            channel.writeAndFlush(new Date()+"hello world!");
            Thread.sleep(2000);
        }

    }
}
