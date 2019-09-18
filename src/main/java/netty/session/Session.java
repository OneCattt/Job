package netty.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Session
 * @Description Session
 * @Author jiangruliang
 * @Date 2019/9/11 14:02
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Session {
    //用户唯一标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
