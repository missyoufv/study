package com.rpc;

/**
 * @author: duw
 * @Date: 2019/10/11 10:33
 * @Description:
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
