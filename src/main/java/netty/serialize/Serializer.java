package netty.serialize;

import netty.serialize.impl.JsonSerializer;

public interface Serializer {

    /**
     * json序列化
     */
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JsonSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * Java对象转换为二进制
     */
    byte[] serialze(Object object);

    /**
     * 二进制转换为Java对象
     */
    <T> T deserialze(Class<T> tClass, byte[] bytes);
}
