package chapter10.homework03;

public class Homework03 {

    /*
    3.编程题
    按要求实现下列问题:
    1．动物类Animal包含了抽象方法shout();
    2.Cat类继承了Animal，并实现方法shout，打印“猫会瞄瞄叫”
    3.Dog类继承了Animal，并实现方法shout，打印“狗会汪注叫”
    4。在测试类中实例化对象Animal cat =new Cat(),并调用cat的shout方法
    5．在测试类中实例化对象Animal dog=new Dog(0,并调用dog的shout方法
     */

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();  // 猫会瞄瞄叫
        Animal dog = new Dog();
        dog.shout();  // 狗会汪注叫
    }
}

abstract class Animal {
    public abstract void shout();
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫会瞄瞄叫");
    }
}

class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗会汪注叫");
    }
}
