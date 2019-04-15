package com.concurrent.future;

/**
 * Main函数主要负责调用Client发起请求，并使用返回的数据
 */
public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        // 这里会立即返回，因为获取的是FutureData，而非RealData
        Data data = client.request("name");
        System.out.println("请求完毕");

        try {
            // 这里可以用一个sleep代替对其他业务逻辑的处理
            // 在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
//            Thread.sleep(2000);

            // 使用真实数据
            System.out.println("数据=" + data.getResult());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
