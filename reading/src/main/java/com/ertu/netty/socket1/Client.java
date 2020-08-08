package com.ertu.netty.socket1;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * @author hxf
 * @date 2019/5/28 22:50
 */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 5000;
    private static Logger logger = Logger.getLogger(Client.class);

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(() -> {
            System.out.println("客户端启动成功！！！");
            while (true) {
                try {
                    String message = "hello world";
                    System.out.println("客户端发送数据: " + message);
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sleep();
            }
        }).start();

    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
