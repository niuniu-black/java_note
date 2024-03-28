package chapter10.homework04;

public class Homework04 {

    /*
    4.编程题
    1、计算器接口具有work方法，功能是运算，有一个手机类Cellphone，定义方法testWork测试计算功能，调用计算接口的work方法，
    2.要求调用CellPhone对象的testWork方法，使用上匿名内部类
     */

    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        /*
        // 以下是匿名内部类
        new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 同时也是一个对象
        他的编译类型是 ICalculate，塔的运行类型是 匿名内部类
         */
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {  // 2.
                return n1 + n2;
            }
        }, 1, 2);
    }
}

interface ICalculate {
    // 该方法完成怎么样的计算，交给匿名内部类完成
    public double work(double n1, double n2);
}

class Cellphone {
    // 当我们调用 testWork 方法时，直接传入一个实现了 ICalculate 接口的匿名内部类即可
    // 该匿名内部类，可以灵活的实现 work ，完成不同的计算任务
    public void testWork(ICalculate iCalculate, double n1, double n2) {
        double result = iCalculate.work(n1, n2);  // 动态绑定  1.  3.
        System.out.println("result = " + result);  // 4.
    }
}
