package com.pattern.facade.base;


/**
 * 从用户调用的代码上可以看到，需要逐个去实例化各个硬件的对象，然后还得一个个的去调用开关方法很麻烦。
 */
public class User {

    public static void main(String[] args) {

        CPU cpu = new CPU();
        GPU gpu = new GPU();
        Memory memory = new Memory();
        Disk disk = new Disk();

        cpu.turnOn();
        gpu.turnOn();
        memory.turnOn();
        disk.turnOn();

        cpu.turnOff();
        gpu.turnOff();
        memory.turnOff();
        disk.turnOff();

    }
}
