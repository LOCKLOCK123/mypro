package netty.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import netty.protocol.constant.Attributes;
import netty.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linlang
 * @date 2018/10/30
 */
public class SessionUtil {
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static  void bindSession(Session session, Channel channel){
        userIdChannelMap.put(session.getUserId(), channel);
        Attribute<Session> attribute = channel.attr(Attributes.SESSION);
        attribute.set(session);
    }

    public static void unbindSession(Channel channel){
        if (hasLogin(channel)){
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }


    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }
}
