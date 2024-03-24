package chapter07;

public class Homework11 {

    /*
    11.在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，调用语句为: System.out.println(method(method(10.0,20.0),100);
     */

    static double method(double num1, double num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println(method(method(10.0,20.0),100));
    }
}
