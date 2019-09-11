package netty;

import io.netty.util.AttributeKey;
import netty.session.Session;

/**
 * @author jiangruliang
 */
public interface Attributes {
    /**
     * 登录标志
     */
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    /**
     * session
     */
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

    Byte CONNECTION_NUM = 0;
}
