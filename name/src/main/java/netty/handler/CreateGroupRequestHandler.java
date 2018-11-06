package netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import netty.protocol.CreateGroupRequestPacket;
import netty.protocol.CreateGroupResponsePacket;
import netty.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author linlang
 * @date 2018/11/5
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        List<String> userIdList = msg.getUserIdList();

        List<String> userNameList = new ArrayList<>();
        // 1. 创建一个 channel 分组
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        // 2. 筛选出待加入群聊的用户的 channel 和 userName
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 3. 创建群聊创建结果的响应
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(getRandomId());
        createGroupResponsePacket.setUsernameList(userNameList);

        // 4. 给每个客户端发送拉群通知
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + createGroupResponsePacket.getUsernameList());

    }

    private String getRandomId() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str;
    }
}
