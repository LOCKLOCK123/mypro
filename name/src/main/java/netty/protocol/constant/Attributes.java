package netty.protocol.constant;

import io.netty.util.AttributeKey;
import netty.session.Session;

/**
 * @author linlang
 * @date 2018/9/30
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    public  static final AttributeKey<Session> SESSION = AttributeKey.valueOf("netty.session.Session");
}
