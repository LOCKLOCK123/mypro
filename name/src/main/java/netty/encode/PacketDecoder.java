package netty.encode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author linlang
 * @date 2018/9/29
 */
public class PacketDecoder extends ByteToMessageDecoder{


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) throws Exception {
        out.add(PacketCodeC.INSTANCE.decode(in));
    }

}
