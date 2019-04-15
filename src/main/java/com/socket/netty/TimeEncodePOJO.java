package com.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 服务器数据编辑类
 */
public class TimeEncodePOJO extends MessageToByteEncoder<Time> {

    //发送数据时调用
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Time time, ByteBuf byteBuf) throws Exception {
        //只输出当前时间，精确到秒
        byteBuf.writeInt((int) time.getValue());
    }
}
