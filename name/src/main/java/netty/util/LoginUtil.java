package netty.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import netty.protocol.constant.Attributes;

/**
 * @author linlang
 * @date 2018/9/30
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
