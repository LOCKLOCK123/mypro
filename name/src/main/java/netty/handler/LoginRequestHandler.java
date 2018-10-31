package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.encode.PacketCodeC;
import netty.protocol.LoginRequestPacket;
import netty.protocol.LoginResponsePacket;
import netty.session.Session;
import netty.util.LoginUtil;
import netty.util.SessionUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @author linlang
 * @date 2018/9/29
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        System.out.println(new Date() + ": 收到客户端登录请求……");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        String userId = getRandomId();
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            loginResponsePacket.setUserId(userId);
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
            // 登录响应
            ctx.channel().writeAndFlush(loginResponsePacket);
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }

        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    private String getRandomId() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }
}
