package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.encode.PacketCodeC;
import netty.protocol.JSONSerializer;
import netty.protocol.LoginRequestPacket;
import netty.protocol.LoginResponsePacket;
import netty.protocol.Packet;

import java.util.Date;
import java.util.UUID;

/**
 * @author linlang
 * @date 2018/9/29
 */
public class ClientHandler  extends ChannelInboundHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端开始登录");
        // 创建登录对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("flash");
        loginRequestPacket.setPassword("pwd");

        // 编码
      /*  ByteBuf buffer = PacketCodeC.INSTANCE.encode(ctx.alloc(),loginRequestPacket);


        // 写数据
        ctx.channel().writeAndFlush(buffer);*/
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;

        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginResponsePacket){
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;

            if (loginResponsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }

        }

    }
}
