package com.socket.keepalive;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: duw
 * @Date: 2019/9/25 14:53
 * @Description: 维持连接发送的消息对象
 */
public class KeepAlive implements Serializable {

    @Override
    public String toString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"\t维持连接包";
    }
}
