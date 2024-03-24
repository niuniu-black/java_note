package chapter07;

public class Homework07 {

    /*
    7.设计一个Dog类，有名字、颜色和年龄属性，定义输出方法show()显示其信息。并创建对象，进行测试、【提示 this.属性，自己做】
     */

    public static void main(String[] args) {

        Dog dog = new Dog("tom", "spot", 10);

        dog.show();
    }
}

class Dog {

    String name;
    String color;
    int age;

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void show() {
        System.out.println(this.name + " 的是一只" + this.age + "岁，" + this.color + "花色的狗。");
    }
}
