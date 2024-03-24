package chapter07;

public class Homework10 {

    /*
    10.试写出以下代码的运行结果
    答：
    i = 101
    j = 100
    101
    101
     */

    public static void main(String[] args) {

        Demo demo1 = new Demo();
        Demo demo2 = demo1;

        demo2.m();

        System.out.println(demo1.i);
        System.out.println(demo2.i);
    }
}

class Demo {

    int i = 100;

    public void m() {

        int j = i++;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }
}
