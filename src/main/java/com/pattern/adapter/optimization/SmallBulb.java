package com.pattern.adapter.optimization;

/**
 * 我现在要加入一个小灯泡，但是它们实现的方法不一样：
 * 这时候就需要加上一个适配器类了：
 */
public class SmallBulb {

    public void electrify() {

        System.out.println("使用1V电压给小灯泡通电");

    }
}
