package com.socket.keepalive;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: duw
 * @Date: 2019/9/25 14:55
 * @Description:
 */
public class Client {

    private String serverIp;
    private int port;
    private Socket socket;
    /**
     * 连接状态
     */
    private boolean running=false;
    /**
     *
     */
    private long lastSendTime;

    public static void main(String[] args) {
        HashMap map = null;
        ConcurrentHashMap chm = null;

    }

}
