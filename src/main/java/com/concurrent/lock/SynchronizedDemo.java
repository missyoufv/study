package com.concurrent.lock;

/**
 * @author: duw
 * @Date: 2019/9/30 17:19
 * @Description:
 *      当SyncTest.java被编译成class文件的时候，synchronized关键字和synchronized方法的字节码略有不同，我们可以用javap -v
 *      命令查看class文件对应的JVM字节码信息，部分信息如下：
 */
public class SynchronizedDemo {

    public void syncBlock(){
        synchronized (this){
            System.out.println("hello block");
        }
    }

    public synchronized void syncMethod(){
        System.out.println("hello method");
    }

    public static void main(String[] args) {
        new SynchronizedDemo().syncBlock();
        new SynchronizedDemo().syncMethod();
    }
}
