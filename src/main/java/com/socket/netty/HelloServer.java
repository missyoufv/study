package com.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServer {

    private int port;

    public HelloServer(int port){
        this.port = port;
    }

    public void run()throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        System.out.println("准备运行端口："+port);

        try{

            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //自定义处理类
                    socketChannel.pipeline().addLast(new HelloServerHandler());
                }
            })
            .option(ChannelOption.SO_BACKLOG,128)
            .childOption(ChannelOption.SO_KEEPALIVE,true);

            //绑定端口，开始接受进来的连接
            ChannelFuture f = b.bind(port).sync();

            //等待服务器socket关闭
            f.channel().closeFuture().sync();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        int port = 10024;
        new HelloServer(port).run();
    }
}
