package netty.command.impl;

import io.netty.channel.Channel;
import netty.command.ConsoleCommand;
import netty.packet.request.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * @ClassName JoinGroupConsoleCommand
 * @Description 加入群聊命令
 * @Author jiangruliang
 * @Date 2019/9/18 11:46
 * @Version 1.0
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();
        System.out.print("请输入群聊id:");
        String groupId = scanner.next();
        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}
