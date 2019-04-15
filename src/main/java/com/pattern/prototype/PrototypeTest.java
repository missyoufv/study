package com.pattern.prototype;

/**
 * 思考：深度拷贝和浅度拷贝
 *
 * 如下都是浅拷贝，深拷贝？？？
 */
class Realizetype implements Cloneable {

    private Integer age = 18;
    private String name = "test";
    private Object object = new Object();

    private int height = 80;

    Realizetype(){
        System.out.println("具体原型创建成功！");
    }
    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype)super.clone();
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Object getObject() {
        return object;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
//原型模式的测试类
public class PrototypeTest {
    public static void main(String[] args)throws CloneNotSupportedException
    {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype)obj1.clone();
        System.out.println("obj1 == obj2 ?"+(obj1==obj2));
        System.out.println("obj1.name == obj2.name?" + (obj1.getName() == obj2.getName()));
        System.out.println("obj1.age == obj2.age?" + (obj1.getAge() == obj2.getAge()));
        System.out.println("obj1.obj == obj2.obj?" + (obj1.getObject() == obj2.getObject()));
        obj2.setName("fighting");
        obj2.setAge(55);
        obj2.setHeight(100);
        System.out.println(obj1.getName());
        System.out.println(obj2.getName());
        System.out.println(obj1.getAge());
        System.out.println(obj2.getAge());
        System.out.println(obj1.getHeight());
        System.out.println(obj2.getHeight());
        System.out.println("after change obj1.name == obj2.name?" + (obj1.getName() == obj2.getName()));
        System.out.println("after change obj1.age == obj2.age?" + (obj1.getAge() == obj2.getAge()));
        System.out.println("after change obj1.height == obj2.height?" + (obj1.getHeight() == obj2.getHeight()));
    }
}