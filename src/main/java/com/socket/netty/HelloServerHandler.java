package com.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class HelloServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        try{

            ByteBuf in = (ByteBuf)msg;
            System.out.println(in.toString(CharsetUtil.UTF_8));

        }catch (Exception ex){
            //抛弃收到的数据
            ReferenceCountUtil.release(msg);
        }
    }

    /**
     * 当netty由于IO错误或者处理器在处理事件时抛出异常时调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
