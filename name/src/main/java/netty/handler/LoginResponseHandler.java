package netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import netty.protocol.LoginRequestPacket;
import netty.protocol.LoginResponsePacket;
import netty.util.LoginUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @author linlang
 * @date 2018/9/29
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket>{


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 写数据
        //ctx.channel().writeAndFlush(loginRequestPacket);
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + msg.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}
