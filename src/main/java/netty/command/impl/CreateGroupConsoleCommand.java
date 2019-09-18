package netty.command.impl;

import io.netty.channel.Channel;

import netty.command.ConsoleCommand;
import netty.packet.request.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName CreateGroupConsoleCommand
 * @Description 创建群聊命令
 * @Author jiangruliang
 * @Date 2019/9/17 16:19
 * @Version 1.0
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    private static final String USER_ID_SPLITER=",";
    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket=new CreateGroupRequestPacket();
        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        String userIds=scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
