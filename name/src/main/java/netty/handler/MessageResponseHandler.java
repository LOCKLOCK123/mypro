package netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.protocol.MessageResponsePacket;

import java.util.Date;

/**
 * @author linlang
 * @date 2018/10/8
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        System.out.println(new Date() + ": 收到服务端的消息: " + msg.getMessage());
    }
}
