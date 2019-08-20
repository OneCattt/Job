package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NettyClient
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/20 14:48
 * @Version 1.0
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        bootstrap
                //1.指定线程模型
                .group(workerGroup)
                //2.指定io类型为NIO
                .channel(NioSocketChannel.class)
                //3.处理逻辑
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) {
                        channel.pipeline().addLast(new StringDecoder());
                    }
                });
        //建立连接
        connect(bootstrap, "127.0.0.1", 1000, MAX_RETRY);



    }

    final private static int MAX_RETRY = 5;

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功！");
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接");
            } else {
                //第几次重连
                int order = MAX_RETRY - retry + 1;
                //本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + "连接失败！,第" + order + "次重连....");
                bootstrap.config().group().schedule(
                        () -> connect(bootstrap, host, port, retry - 1),delay, TimeUnit.SECONDS);
            }
        });
    }
}
