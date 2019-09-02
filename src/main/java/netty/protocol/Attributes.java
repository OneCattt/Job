package netty.protocol;

import io.netty.util.AttributeKey;

/**
 * @author jiangruliang
 */
public interface Attributes {
    /**
     *登录标志
     */
    AttributeKey<Boolean> LOGIN=AttributeKey.newInstance("login");
}
