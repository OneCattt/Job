package netty.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ClassName ConsoleCommand
 * @Description 控制台命令执行器
 * @Author jiangruliang
 * @Date 2019/9/17 16:10
 * @Version 1.0
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
