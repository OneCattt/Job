package netty.util;

import java.util.UUID;

/**
 * @ClassName IDUtil
 * @Description 获取
 * @Author jiangruliang
 * @Date 2019/9/17 17:21
 * @Version 1.0
 */
public class IDUtil {
    public static String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
