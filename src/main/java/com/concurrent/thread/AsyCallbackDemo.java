package com.concurrent.thread;

/**
 * @author: duw
 * @Date: 2019/12/2 14:56
 * @Description: 实现异步回调功能
 *
 * 背景:在JDK5中增加了Future异步获取结果的功能，但是这种方式在获取的时候是阻塞的，在正常场景下这种实现方式肯定是不太友好的，
 * 当然可以通过轮询的方式去获取异步结果，但是这种方式比较消耗CPU并且获取结果也不会太及时，所以也不提倡使用；在jdk7中提供了CompletionService的take和pool方法，
 * 来获取执行的结果；jdk8中的CompletableFuture也是非常强大的实现了异步回调的功能；另外很多开源框架自己也实现了异步回调功能，像Netty的channelFuture，
 * 通过addListener来实现异步回调的编程方式；Guava也是同样的通过ListenableFuture实现了异步回调的编程方式。
 */
public class AsyCallbackDemo {


}
