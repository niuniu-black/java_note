package chapter07;

public class Homework13 {

    /*
    13.将对象作为参数传递给方法。题目要求:
    (1)定义一个Circle类，包含一个double型的radius属性代表圆的半径，findArea()方法返回圆的面积。
    (2)定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下:public void printAreas(Circle c, int times)  //方法签名
    (3)在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
    (4)在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示
    Raduis          Area
    1.0             3.141592653589793
    2.0             12.566370614359172
    3.0             28.274333882308138
    4.0             50.26548245743669
    5.0             78.53981633974483
     */

    public static void main(String[] args) {

        Circle13 circle13 = new Circle13();
        new PassObject().printAreas(circle13, 5);
    }
}

class Circle13 {

    double radius;

    public double findArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class PassObject {

    public void printAreas(Circle13 c, int times) {

        System.out.println("Raduis\t\t\tArea");
        for (int i = 1; i <= times; i++) {
            c.setRadius(i);
            System.out.println((double) i + "\t\t\t\t" + c.findArea());
        }
    }
}
