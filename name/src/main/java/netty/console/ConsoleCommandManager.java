package netty.console;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author linlang
 * @date 2018/11/5
 */
public class ConsoleCommandManager implements  ConsoleCommand{

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("createGroup", new CreateGroupConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        //  获取第一个指令
        String command = scanner.next();

        ConsoleCommand consoleCommand = consoleCommandMap.get(command);

        if (consoleCommand != null) {
            consoleCommand.exec(scanner, channel);
        } else {
            System.err.println("无法识别[" + command + "]指令，请重新输入!");
        }
    }
}
