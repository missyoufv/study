package com.rpc;

import java.io.IOException;

/**
 * @author: duw
 * @Date: 2019/10/11 10:34
 * @Description:
 */
public interface Server {

    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
