package javaa.serializablee;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Author jiangruliang
 * @Date 2019/11/27 9:56
 * @Version 1.0
 */
public class SerializableTest {
    public static void main(String[] args) throws Exception {
        serializerFlyPig();
        FlyPig flyPig=deserializeFlyPig();
        System.out.println(flyPig.toString());
    }

    /**
     * 序列化
     * @throws IOException
     */
    private static void serializerFlyPig() throws IOException {
        FlyPig flyPig=new FlyPig();
        flyPig.setColor("black");
        flyPig.setCar("volvo");
        flyPig.setName("jiangruliang");
        flyPig.setAddTip("formal");
        // ObjectOutputStream 对象输出流，将 flyPig 对象存储到E盘的 flyPig.txt 文件中，完成对 flyPig 对象的序列化操作
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("d:/flyPig.txt")));
        oos.writeObject(flyPig);
        System.out.println("FlyPig 对象序列化成功");
        oos.close();
    }

    private static FlyPig deserializeFlyPig() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("d:/flyPig.txt")));
        FlyPig flyPig=(FlyPig)ois.readObject();
        System.out.println("FlyPig 对象反序列化成功");
        return flyPig;
    }

}
