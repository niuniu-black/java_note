package chapter06;

public class Homework02 {

    /*
    2.写出下面程序的结果
    答：
    blue
     */

    public static void main(String[] args) {

        String foo = "blue";
        boolean[] bar = new boolean[2];

        if (bar[0]) {
            foo = "green";
        }

        System.out.println(foo);
    }
}
