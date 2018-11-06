package netty.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author linlang
 * @date 2018/11/5
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
