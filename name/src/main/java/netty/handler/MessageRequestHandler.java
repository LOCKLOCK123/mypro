package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.encode.PacketCodeC;
import netty.protocol.MessageRequestPacket;
import netty.protocol.MessageResponsePacket;
import netty.session.Session;
import netty.util.SessionUtil;

import java.util.Date;

/**
 * @author linlang
 * @date 2018/10/8
 */
public class MessageRequestHandler  extends SimpleChannelInboundHandler<MessageRequestPacket>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        Session session = SessionUtil.getSession(ctx.channel());
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(msg.getMessage());
        Channel toUserChannel = SessionUtil.getChannel(msg.getToUserId());


        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + msg.getToUserId() + "] 不在线，发送失败!");
        }
    }
}
