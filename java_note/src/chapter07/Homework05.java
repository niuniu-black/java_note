package chapter07;

public class Homework05 {

    /*
    5.定义一个圆类Circle,定义属性:半径，提供显示圆周长功能的方法，提供显示圆面积的方法
     */

    public static void main(String[] args) {

        double r = 2;

        Circle circle = new Circle(r);

        circle.getCir();
        circle.getArea();
    }
}

class Circle {

    double r;

    public double getR() {
        return r;
    }

    public Circle(double r) {
        this.r = r;
    }

    public void getCir() {
        System.out.println("the circle circumference is " + (2 * Math.PI * this.r));
    }

    public void getArea() {
        System.out.println("the circle area is " + (Math.PI * Math.pow(this.r, 2)));
    }
}