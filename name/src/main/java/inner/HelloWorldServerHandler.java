package inner;

/**
 * @author linlang
 * @date 2018/10/31
 */
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.ChannelInboundHandlerAdapter;


public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {


    @Override

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println("server channelRead..");

        System.out.println(ctx.channel().remoteAddress() + "->Server :" + msg.toString());
        System.out.println(ctx.channel().id());
        ctx.write("server write" + msg);

        ctx.flush();

    }


    @Override

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        cause.printStackTrace();

        ctx.close();

    }


}
