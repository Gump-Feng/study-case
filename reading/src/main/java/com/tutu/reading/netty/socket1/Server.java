package com.tutu.reading.netty.socket1;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hxf
 * @date 2019/5/28 23:00
 */
public class Server {
    private ServerSocket serverSocket;
    private static Logger logger = Logger.getLogger(Server.class);

    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }

    private Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功！！！");
        } catch (Exception e) {
            System.out.println("服务端启动失败！！！\n失败原因：" + e.getMessage());
        }
    }

    private void start() {
        new Thread(this::doStart).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }
    }
}
