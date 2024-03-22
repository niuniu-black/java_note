package chapter06;

public class Homework03 {

    /*
    3.以下Java代码额输出结果为
    答：
    1
    3
    5
    7
     */

    public static void main(String[] args) {

        int num = 1;

        while (num < 10) {
            System.out.println(num);

            if (num > 5) {
                break;
            }

            num += 2;
        }
    }
}
