package netty.command.impl;

import io.netty.channel.Channel;
import netty.command.ConsoleCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName ConsoleCommandManager
 * @Description 管理控制台命令执行器
 * @Author jiangruliang
 * @Date 2019/9/17 16:13
 * @Version 1.0
 */
public class ConsoleCommandManager implements ConsoleCommand {

    private Map<String, ConsoleCommand> consoleCommandMap;

    public ConsoleCommandManager() {
        consoleCommandMap = new HashMap<>();
        consoleCommandMap.put("sendToUser", new SendToUserConsoleCommand());
        consoleCommandMap.put("logout", new LogoutConsoleCommand());
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
