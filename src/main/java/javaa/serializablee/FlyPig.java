package javaa.serializablee;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName FlyPig
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/11/27 9:55
 * @Version 1.0
 */
@Data
public class FlyPig implements Serializable {
    public static final long serialVersionUID = 1L;
    private static String AGE = "269";
    private String name;
    private String color;
    transient private String car;
    private String addTip = "TEST";

    @Override
    public String toString() {
        return "FlyPig{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", car='" + car + '\'' +
                ", AGE='" + AGE + '\'' +
                ", addTip='" + addTip + '\'' +
                '}';
    }
}
