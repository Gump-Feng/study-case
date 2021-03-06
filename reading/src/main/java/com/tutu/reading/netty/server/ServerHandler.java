package com.tutu.reading.netty.server;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * @author hxf
 * @date 2019/4/29 22:24
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        FileUtils.writeByteArrayToFile(new File("C:\\Users\\houxf\\Desktop\\netty_file\\server\\https-demo.jar"), req);
        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("server :" + body.length());
        String response = "进行返回给客户端的响应：" + body;
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        //接收到客户端的数据立马断掉客户端连接 服务端还是启动着
        //.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("读完了");
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel active... ");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
