package rpc;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author linlang
 * @date 2018/9/25
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

     @Override

        public void channelActive(ChannelHandlerContext ctx) {

            System.out.println("HelloWorldClientHandler Active");

        }



        @Override

        public void channelRead(ChannelHandlerContext ctx, Object msg) {

            System.out.println("HelloWorldClientHandler read Message:"+msg);

        }





        @Override

        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

            cause.printStackTrace();

            ctx.close();

        }

}
