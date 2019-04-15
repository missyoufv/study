package com.concurrent.future;

/**
 * RealData是最终需要使用的数据模型，它的构造很慢。在这里，使用sleep()函数模拟这个过程
 */
public class RealData implements Data{

    protected String data;

    public RealData(String data){

        // 利用sleep方法来表示RealData构造过程是非常缓慢的
        try{
            Thread.sleep(1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        this.data = data;
    }
    @Override
    public String getResult() throws InterruptedException {
        return data;
    }
}
