package chapter07;

public class Homework08 {  // 公有类

    /*
    8.给定一个Java程序的代码如下所示，则编译运行后，输出结果是
    答：
    count1 = 10
    count2 = 9
    count2 = 10
     */

    int count = 9;  // 属性

    public void count1() {  // Homework08 类的成员方法
        count = 10;  // 这个count就是属性
        System.out.println("count1 = " + count);
    }

    public void count2() {  // Homework08 类的成员方法
        System.out.println("count2 = " + count++);
    }

    // 这是 Homework08 的 main 方法，任何一个类，都可以有 main 方法
    public static void main(String[] args) {
        // 1、new Homework08() 是匿名对象，匿名对象使用后，就不能使用了，会被销毁
        // 2、new Homework08().count1(); 创建好匿名对象后，就调用 count1()
        new Homework08().count1();

        Homework08 homework08 = new Homework08();
        homework08.count2();
        homework08.count2();
    }
}
