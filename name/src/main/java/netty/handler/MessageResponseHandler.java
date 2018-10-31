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
        String fromUserId = msg.getFromUserId();
        String fromUserName = msg.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + msg .getMessage());
    }
}
