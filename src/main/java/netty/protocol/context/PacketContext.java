package netty.protocol.context;

import netty.protocol.Packet;

/**
 * @ClassName PacketContext
 * @Description jiangruliang
 * @Author TOPFEEL
 * @Date 2019/8/30 16:50
 * @Version 1.0
 */
public class PacketContext {

    private Packet packet;

    public PacketContext(Packet packet){
        this.packet=packet;
    }



}
