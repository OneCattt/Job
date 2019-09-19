package netty.command.impl;

import io.netty.channel.Channel;
import netty.command.ConsoleCommand;
import netty.packet.request.LogoutRequestPacket;

import java.util.Scanner;

/**
 * @ClassName LogoutConsoleCommand
 * @Description 登出命令
 * @Author jiangruliang
 * @Date 2019/9/17 16:33
 * @Version 1.0
 */
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
