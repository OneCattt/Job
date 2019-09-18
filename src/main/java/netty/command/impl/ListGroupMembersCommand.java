package netty.command.impl;

import io.netty.channel.Channel;
import netty.command.ConsoleCommand;
import netty.packet.request.JoinGroupRequestPacket;
import netty.packet.request.ListGroupMembersRequestPacket;

import java.util.Scanner;

/**
 * @ClassName JoinGroupConsoleCommand
 * @Description 加入群聊命令
 * @Author jiangruliang
 * @Date 2019/9/18 11:46
 * @Version 1.0
 */
public class ListGroupMembersCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket listGroupMembersRequestPacket=new ListGroupMembersRequestPacket();
        System.out.print("请输入群聊id获取成员列表:");
        String groupId=scanner.next();
        listGroupMembersRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(listGroupMembersRequestPacket);
    }
}
