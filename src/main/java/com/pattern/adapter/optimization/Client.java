package com.pattern.adapter.optimization;

/**
 * 这样在客户端上就可以使用统一的接口了：
 */
public class Client {

    public static void main(String[] args) {

        DigitalProducts phone = new Phone();
        DigitalProducts ipad = new IPad();
        DigitalProducts macBook = new MacBook();
        DigitalProducts samllBulb = new Adapter();

        phone.charge();
        ipad.charge();
        macBook.charge();
        samllBulb.charge();
    }
}
