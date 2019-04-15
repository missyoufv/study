package com.socket.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 服务器解码器
 * 连接建立时发送当前时间
 */
public class TimeServerHandlerPOJO extends ChannelInboundHandlerAdapter {


    /**
     * 连接建立的时候并且准备进行通信时调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送当前时间信息
        ChannelFuture f = ctx.writeAndFlush(new Time());
        //发送完毕之后关闭 channel
        f.addListener(ChannelFutureListener.CLOSE);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
