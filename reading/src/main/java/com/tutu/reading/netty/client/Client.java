package com.tutu.reading.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author hxf
 * @date 2019/4/29 22:41
 */
public class Client {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        //1
        Bootstrap b = new Bootstrap();
        //2
        b.group(group)
                //3
                .channel(NioSocketChannel.class)
                //4
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        //在这里配置具体数据接收方法的处理
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });

        try {
            //5
            ChannelFuture cf1 = b.connect("127.0.0.1", 8765).sync();

            //创建要传输的文件
            byte[] bytes = FileUtils.readFileToByteArray(new File("C:/Users/houxf/Desktop/netty_file/client/http-parse.jar"));

            //发送消息
            cf1.channel().writeAndFlush(Unpooled.copiedBuffer(bytes));
            Thread.sleep(1000);

            cf1.channel().closeFuture().sync();

            //等待关闭
            group.shutdownGracefully();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
