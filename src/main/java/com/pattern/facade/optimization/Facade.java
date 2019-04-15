package com.pattern.facade.optimization;

/**
 * 外观类，它需要了解所有子系统类的方法或属性， 并进行处理、组合，以提供给外部调用
 */
public class Facade {

    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;
    private SubSystemFour subSystemFour;

    public Facade() {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
        subSystemFour = new SubSystemFour();
    }

    public void MethodA() {
        System.out.println("\n 方法组A() -------- ");
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
        subSystemFour.methodFour();
    }

    public void MethodB() {
        System.out.println("\n 方法组B() -------- ");
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
        subSystemThree.methodThree();
    }

}
