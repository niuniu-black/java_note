package chapter12.homework03;

public class Homework03 {

    /*
     3.写出程序结果():
     result:
     B
     C
     D
     */
    public static void func() {
        try {
            throw new RuntimeException();  // 2
        } finally {
            System.out.println("B");  // 3
        }
    }

    public static void main(String[] args) {
        try {
            func();  // 1  , 接收到 func 抛出的异常
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("C");  // 4
        }
        System.out.println("D");  // 5
    }

}
