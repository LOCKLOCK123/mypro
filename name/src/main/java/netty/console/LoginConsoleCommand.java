package netty.console;

import io.netty.channel.Channel;
import netty.protocol.LoginRequestPacket;

import java.util.Scanner;

/**
 * @author linlang
 * @date 2018/11/5
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("输入用户名登录: ");
        String username = scanner.nextLine();
        loginRequestPacket.setUsername(username);
        loginRequestPacket.setPassword("pwd");
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }


}
