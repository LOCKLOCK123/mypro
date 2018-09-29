package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.encode.PacketCodeC;
import netty.protocol.LoginRequestPacket;
import netty.protocol.LoginResponsePacket;

/**
 * @author linlang
 * @date 2018/9/29
 */
public class LoginRequestHandler  extends SimpleChannelInboundHandler<LoginRequestPacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        ctx.channel().writeAndFlush(login(msg));
    }


    private LoginResponsePacket login(LoginRequestPacket loginRequestPacket){
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        if(loginRequestPacket != null){
           loginResponsePacket.setSuccess(true);
        }else {
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("！！！！啊哦，炉石传说真尼玛好玩！！！！");
        }
        return  loginResponsePacket;
    }
}
