package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.protocol.Packet;
import netty.protocol.PacketCodeC;
import netty.protocol.impl.LoginRequestPacket;
import netty.protocol.impl.LoginResponsePacket;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstServerHandler
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/8/26 16:13
 * @Version 1.0
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    static {
        Map<String,Object> map=new HashMap<>();
        map.put("LoginRequestPacket","netty.protocol.impl.LoginRequestPacket");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //读取客户端发送过来的数据
        ByteBuf requestByteBuf = (ByteBuf) msg;
        //解码
        Packet packet= PacketCodeC.ourInstance.decode(requestByteBuf);
        if (packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket=(LoginRequestPacket)packet;
            LoginResponsePacket loginResponsePacket=new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)){
                //校验成功
                loginResponsePacket.setSuccess(true);
            }else {
                //校验失败
                loginResponsePacket.setReson("账号或用户名错误");
                loginResponsePacket.setSuccess(false);
            }
            ByteBuf responseByteBuf=PacketCodeC.ourInstance.encode(ctx.alloc(),loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }

    }
    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }


}
