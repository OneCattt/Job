package netty.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import netty.Attributes;

/**
 * @ClassName LoginUtil
 * @Description 登录工具类
 * @Author jiangruliang
 * @Date 2019/9/2 14:34
 * @Version 1.0
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
        return loginAttr.get() != null;
    }
}
