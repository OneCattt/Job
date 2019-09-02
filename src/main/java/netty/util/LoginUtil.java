package netty.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import netty.protocol.Attributes;

/**
 * @ClassName LoginUtil
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/9/2 14:34
 * @Version 1.0
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> loginAttr=channel.attr(Attributes.LOGIN);
        return loginAttr.get()!=null;
    }
}
