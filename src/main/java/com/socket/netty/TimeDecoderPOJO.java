package com.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class TimeDecoderPOJO extends ByteToMessageDecoder {

    /**
     * 有新数据接收时调用
     * 为了防止分包现象，先将数据存到内部缓存，到达满足条件之后再进行解码
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if(byteBuf.readableBytes() <4){
            return;
        }
        //添加对象表示解码成功
        list.add(new Time(byteBuf.readUnsignedInt()));
    }
}
