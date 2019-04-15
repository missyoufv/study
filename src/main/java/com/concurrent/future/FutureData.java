package com.concurrent.future;


/**
 * FutureData实现了一个快速返回的RealData包装。它只是一个包装，或者说是一个RealData的虚拟实现。因此，它可以很快被构造并返回。当使用FutureData的getResult()方法是，
 *  程序会阻塞，等待RealData被注入到程序中，才使用RealData的getResult()方法返回。
 */
public class FutureData implements Data{

    private RealData realData = null; // FutureData是RealData的封装

    private boolean isReady = false; // 是否已经准备好

    @Override
    public synchronized String getResult() throws InterruptedException {
        if(!isReady){
            System.out.println("heihei");
            wait(); // 一直等到RealData注入到FutureData中
        }

        return realData.getResult();
    }


    public synchronized  void setRealData(RealData realData){
        if(isReady)
            return;
        this.realData = realData;
        isReady = true;
        notify();// RealData已经被注入到FutureData中了，通知getResult()方法
    }
}
