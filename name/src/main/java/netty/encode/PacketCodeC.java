package netty.encode;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import netty.protocol.*;
import netty.protocol.constant.Command;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class PacketCodeC {

    private static final int MAGIC_NUMBER = 0x12345678;

    public static final PacketCodeC INSTANCE = new PacketCodeC();

    public void encode(ByteBuf byteBuf, Packet packet) {

        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeByte(bytes.length);
        byteBuf.writeBytes(bytes);
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
        int length = byteBuf.readByte();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);
        Class<? extends Packet> requestType = LoginRequestPacket.class;
        if (command == Command.LOGIN_RESPONSE) {requestType = LoginResponsePacket.class;}
        else if(command == Command.MESSAGE_REQUEST){requestType = MessageRequestPacket.class;}
        else if (command == Command.MESSAGE_RESPONSE){requestType = MessageResponsePacket.class;}
        Serializer serializer = new JSONSerializer();

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;


    }
}
