package netty.util;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import netty.Attributes;
import netty.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SessionUtil
 * @Description session工具类
 * @Author jiangruliang
 * @Date 2019/9/11 13:59
 * @Version 1.0
 */
public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupIdChannelMap = new ConcurrentHashMap<>();
    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }
    public static void bindGroupId(String groupId, ChannelGroup channelGroup) {
        groupIdChannelMap.put(groupId,channelGroup);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            Session session = getSession(channel);
            userIdChannelMap.remove(session.getUserId());
            channel.attr(Attributes.SESSION).set(null);
            System.out.println(session + " 退出登录!");
        }
    }

    public static boolean hasLogin(Channel channel) {
        return getSession(channel)!=null;
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }
    public static ChannelGroup getChannelGroup(String groupId){
        return groupIdChannelMap.get(groupId);
    }
}
