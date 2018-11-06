package netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.protocol.CreateGroupResponsePacket;

/**
 * @author linlang
 * @date 2018/11/5
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        System.out.print("群创建成功，id 为[" + msg.getGroupId() + "], ");
        System.out.println("群里面有：" + msg.getUsernameList());

    }
}
