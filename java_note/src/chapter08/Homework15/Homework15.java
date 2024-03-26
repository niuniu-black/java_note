package chapter08.Homework15;

public class Homework15 {

    /*
    15.什么是多态,多态更体体现有哪些?(可举例说明)
    答：
    多态：方法或对象具有多种形态，是OOP的三大特征，是建立在封装和继承基础之上。
    多态具体体现：
    1.方法多态
    1.1 重载体现多态
    1.2 重写体现多态
    2.对象多态
    2.1 对象的编译类型和运行类型可以不一致，编译类型在定义时，就确定，不能变化
    2.2 对象的运行类型是可以变化的，可以通过 getClass() 来查看运行类型
    2.3 编译类型看定义时 = 号的左边，运行类型看 = 号的右边
     */

    public static void main(String[] args) {
        AAA obj = new BBB();  // 向上转型
        AAA b1 = obj;
        System.out.println("obj的运行类型=" + obj.getClass());  // BBB
        obj = new CCC();  // 向上转型
        System.out.println("obj的运行类型=" + obj.getClass());  // CCC
        obj = b1;
        System.out.println("obj的运行类型=" + obj.getClass());  // BBB
    }
}

class AAA {}

class BBB extends AAA {}

class CCC extends BBB {}
