package netty.protocol.constant;

import io.netty.util.AttributeKey;

/**
 * @author linlang
 * @date 2018/9/30
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
