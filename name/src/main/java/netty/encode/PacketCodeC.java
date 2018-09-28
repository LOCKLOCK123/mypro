package netty.encode;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import netty.protocol.JSONSerializer;
import netty.protocol.LoginRequestPacket;
import netty.protocol.Packet;
import netty.protocol.Serializer;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class PacketCodeC {

    private static final int MAGIC_NUMBER = 0x12345678;

    public  static final  PacketCodeC INSTANCE = new PacketCodeC();

    public ByteBuf encode(ByteBufAllocator cator,Packet packet) {
        ByteBuf byteBuf = cator.ioBuffer();

        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeByte(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = LoginRequestPacket.class;
        Serializer serializer = new JSONSerializer();

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;


    }
}
