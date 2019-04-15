package com.concurrent.future;

/**
 * Client主要实现了获取futrueData，开启构造RealData的线程，并在接受请求后，很快地返回FutureData
 */
public class Client {

    public Data request(final String data) {

        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    // RealData的构建很慢，所以放在单独的线程中运行
                    RealData realData = new RealData(data);
                    futureData.setRealData(realData);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        }).start();
        return futureData; // 先直接返回FutureData
    }

}
