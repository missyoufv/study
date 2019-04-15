package com.concurrent.future;


/**
 * Data是一个接口，提供了getResult()方法。无论futureData或者RealData都实现了这个接口
 */
public interface Data {
    String getResult() throws InterruptedException;
}
