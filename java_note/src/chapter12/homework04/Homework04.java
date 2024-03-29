package chapter12.homework04;

public class Homework04 {

    /*
    4.写出程序结果():
    result:
    B
    C
    D
     */
    public static void main(String[] args) {
        try {
            showExce();  // 1 , 接收到抛出的异常
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");  // 3
        } finally {
            System.out.println("C");  // 4
        }
        System.out.println("D");  // 5
    }

    public static void showExce() throws Exception {
        throw new Exception();  // 2 , 抛出异常
    }

}
