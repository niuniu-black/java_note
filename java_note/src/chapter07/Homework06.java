package chapter07;

public class Homework06 {

    /*
    6.编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试
     */

    public static void main(String[] args) {

        double num1 = 1;
        double num2 = 0;

        Cale cale1 = new Cale(num1, num2);
        cale1.sum();
        cale1.dif();
        cale1.product();
        cale1.quotient();

        double num3 = 1;
        double num4 = 2;

        Cale cale2 = new Cale(num3, num4);
        cale2.sum();
        cale2.dif();
        cale2.product();
        cale2.quotient();
    }
}

class Cale {

    double num1;
    double num2;

    public Cale(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // 和
    public void sum() {
        System.out.println(this.num1 + " + " + this.num2 + " = " + (this.num1 + this.num2));
    }

    // 差
    public void dif() {
        System.out.println(this.num1 + " - " + this.num2 + " = " + (this.num1 - this.num2));
    }

    // 乘
    public void product() {
        System.out.println(this.num1 + " * " + this.num2 + " = " + (this.num1 * this.num2));
    }

    // 商
    public void quotient() {
        if (num2 == 0) {
            System.out.println("被除数不能为0...");
        } else {
            System.out.println(this.num1 + " / " + this.num2 + " = " + (this.num1 / this.num2));
        }
    }
}
