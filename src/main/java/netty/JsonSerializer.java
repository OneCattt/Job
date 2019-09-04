package netty;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName JsonSerializer
 * @Description json序列化
 * @Author TOPFEEL
 * @Date 2019/8/30 14:44
 * @Version 1.0
 */
public class JsonSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialze(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialze(Class<T> tClass, byte[] bytes) {
        return JSON.parseObject(bytes, tClass);
    }
}
