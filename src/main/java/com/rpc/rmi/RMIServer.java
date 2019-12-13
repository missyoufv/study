package com.rpc.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author: duw
 * @Date: 2019/10/11 11:27
 * @Description:
 * 创建RemoteMath类的实例并在rmiregistry中注册。
 */
public class RMIServer {

    public static void main(String[] args)  {

        try {
            // 注册远程对象,向客户端提供远程对象服务。
            // 远程对象是在远程服务上创建的，你无法确切地知道远程服务器上的对象的名称，
            // 但是,将远程对象注册到RMI Registry之后,
            // 客户端就可以通过RMI Registry请求到该远程服务对象的stub，
            // 利用stub代理就可以访问远程服务对象了。
            IRemoteMath remoteMath = new RemoteMath();
            LocateRegistry.createRegistry(8888);
//            Registry registry = LocateRegistry.getRegistry();
//            registry.bind("Compute", remoteMath);

            Naming.bind("rmi://localhost:8888/RHello", remoteMath);
            System.out.println(">>>>>INFO:远程IHello对象绑定成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
