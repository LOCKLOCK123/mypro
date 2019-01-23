package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import netty.encode.PacketDecoder;
import netty.encode.PacketEncoder;
import netty.handler.AuthHandler;
import netty.handler.CreateGroupRequestHandler;
import netty.handler.LoginRequestHandler;
import netty.handler.MessageRequestHandler; /**
 * @author linlang
 * @date 2018/9/27
 */
/**
 *Netty 服务端启动，将channel注册到Reactor的bossgroup的eventloop里面；检测到客户端的连接之后，挑选一个workgroup中的eventloop处理该连接，包括注册到selector
 * ，读写等操作；一个selector会绑定一个eventloop，处理感兴趣事件
 *
 * 关于reactor线程中的定时任务是外部添加进去的
 */

public class NettyServer {

    public static void main(String[] args){
            take();


    }

    public  static  void  take()  {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {

                        @Override
                        protected void initChannel(NioSocketChannel ch) {
                            ch.pipeline().addLast(new PacketDecoder());
                            ch.pipeline().addLast(new LoginRequestHandler());
                            ch.pipeline().addLast(new AuthHandler());
                            ch.pipeline().addLast(new MessageRequestHandler());
                            ch.pipeline().addLast(new CreateGroupRequestHandler());
                            ch.pipeline().addLast(new PacketEncoder());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(8000).sync().addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    System.out.println("454545");
                }
            });

        }catch (Exception e){}finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}
