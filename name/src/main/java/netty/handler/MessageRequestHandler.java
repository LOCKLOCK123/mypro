package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.encode.PacketCodeC;
import netty.protocol.MessageRequestPacket;
import netty.protocol.MessageResponsePacket;

import java.util.Date;

/**
 * @author linlang
 * @date 2018/10/8
 */
public class MessageRequestHandler  extends SimpleChannelInboundHandler<MessageRequestPacket>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + ": 收到客户端消息: " + msg.getMessage());
        messageResponsePacket.setMessage("服务端回复【" + msg.getMessage() + "】");

        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
