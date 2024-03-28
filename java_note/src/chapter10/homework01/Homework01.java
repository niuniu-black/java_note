package chapter10.homework01;

public class Homework01 {

    /*
    1.试写出以下代码的执行结果
    result:
    9.0 red
    100.0   red
     */
    public static void main(String[] args) {
        Car c = new Car();
        Car c1 = new Car(100);
        System.out.println(c);
        System.out.println(c1);
    }

}

