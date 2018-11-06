package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import netty.console.ConsoleCommandManager;
import netty.console.LoginConsoleCommand;
import netty.encode.PacketCodeC;
import netty.encode.PacketDecoder;
import netty.encode.PacketEncoder;
import netty.handler.ClientHandler;
import netty.handler.CreateGroupResponseHandler;
import netty.handler.LoginResponseHandler;
import netty.handler.MessageResponseHandler;
import netty.protocol.LoginRequestPacket;
import netty.protocol.MessageRequestPacket;
import netty.util.LoginUtil;
import netty.util.SessionUtil;

import java.util.Scanner;

/**
 * @author linlang
 * @date 2018/9/28
 */
public class NettyClient {
    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                // 1.指定线程模型
                .group(workerGroup)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                // 2.指定 IO 类型为 NIO
                .channel(NioSocketChannel.class)
                // 3.IO 处理逻辑
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new PacketDecoder());
                        ch.pipeline().addLast(new LoginResponseHandler());
                        ch.pipeline().addLast(new MessageResponseHandler());
                        ch.pipeline().addLast(new CreateGroupResponseHandler());
                        ch.pipeline().addLast(new PacketEncoder());
                    }
                });
        // 4.建立连接
        bootstrap.connect("127.0.0.1", 8000).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {

                    System.out.println("连接成功!");
                    Channel channel = ((ChannelFuture) future).channel();
                    startConsoleThread(channel);
                } else {
                    System.err.println("连接失败!");
                }
            }
        });
    }


//      System.out.print("输入用户名登录: ");
//    String username = sc.nextLine();
//                        loginRequestPacket.setUsername(username);
//
//    // 密码使用默认的
//                        loginRequestPacket.setPassword("pwd");
//
//    // 发送登录数据包
//                        channel.writeAndFlush(loginRequestPacket);
//    waitForLoginResponse();
//} else {
//        String toUserId = sc.nextLine();
//        String message = sc.nextLine();
//        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
//        }

    private static void startConsoleThread(final Channel channel) {
        final ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        final LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        final Scanner scanner = new Scanner(System.in);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    if (!SessionUtil.hasLogin(channel)) {
                        loginConsoleCommand.exec(scanner, channel);
                    } else {
                        consoleCommandManager.exec(scanner, channel);
                    }}
                }
        }).start();

    }




}
