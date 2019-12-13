package com.rpc.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author: duw
 * @Date: 2019/10/11 11:29
 * @Description:
 */
public class MathClient {

    public static void main(String[] args) {

        try {
            // 如果RMI Registry就在本地机器上，URL就是:rmi://localhost:1099/hello
            // 否则，URL就是：rmi://RMIService_IP:1099/hello
//            Registry registry = LocateRegistry.getRegistry("localhost");
//            // 从Registry中检索远程对象的存根/代理
//            IRemoteMath remoteMath = (IRemoteMath)registry.lookup("Compute");

            IRemoteMath remoteMath = (IRemoteMath) Naming.lookup("rmi://127.0.0.1:8888/RHello");
            // 调用远程对象的方法
            double addResult = remoteMath.add(5.0, 3.0);
            System.out.println("5.0 + 3.0 = " + addResult);
            double subResult = remoteMath.subtract(5.0, 3.0);
            System.out.println("5.0 - 3.0 = " + subResult);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
