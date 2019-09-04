package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.handle.LoginRequestHandle;
import netty.handle.MessageRequestHandle;
import netty.packet.PacketDecoder;
import netty.packet.PacketEncoder;

/**
 * @ClassName NettyServer
 * @Description netty服务端
 * @Author jiangruliang
 * @Date 2019/8/20 14:34
 * @Version 1.0
 */
public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //接受新连接线程，负责创建新连接
        NioEventLoopGroup boss = new NioEventLoopGroup();
        //负责读取数据的线程，主要用于读取数据以及业务逻辑处理
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                //线程模型
                .group(boss, worker)
                //io模型
                .channel(NioServerSocketChannel.class)
                //连续数据读写处理
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        // ch.pipeline().addLast(new FirstServerHandler());
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginRequestHandle());
                        ch.pipeline().addLast(new MessageRequestHandle());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                })
                //TCP底层心跳机制，true为开启
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //true表示关闭，false表示开启，通俗的说，如果要求高实时性，就关闭，如果需要减少网络交互，就开启
                .childOption(ChannelOption.TCP_NODELAY, false)
                //用于已完成三次握手请求队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
                .option(ChannelOption.SO_BACKLOG, 1024);
        bind(serverBootstrap, 1000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
