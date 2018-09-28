package netty.protocol;

import com.alibaba.fastjson.JSON;
import netty.protocol.constant.SerializerAlgorithm;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class JSONSerializer implements Serializer{

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
