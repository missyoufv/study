package com.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author: duw
 * @Date: 2019/10/11 10:51
 * @Description:
 */
public class RPCTest {

    public static void main(String[] args) throws Exception {

        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("studyApi"));
    }
}
