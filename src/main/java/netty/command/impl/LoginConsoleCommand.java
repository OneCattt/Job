package netty.command.impl;

import io.netty.channel.Channel;
import netty.command.ConsoleCommand;
import netty.packet.request.LoginRequestPacket;

import java.util.Scanner;

/**
 * @ClassName LogoutConsoleCommand
 * @Description 登录命令
 * @Author jiangruliang
 * @Date 2019/9/17 16:33
 * @Version 1.0
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.print("输入用户名登录: ");
        String username = scanner.nextLine();
        loginRequestPacket.setUsername(username);

        // 密码使用默认的
        loginRequestPacket.setPassword("pwd");
        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        //登录等待响应，防止2次登录
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
