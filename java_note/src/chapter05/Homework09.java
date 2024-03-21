package chapter05;

public class Homework09 {

    /*
    9.求1+(1+2)+(1+2+3)+(1+2+3+4) +...+(1+2+3+..+100)的结果
     */

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
//                System.out.print(j + " ");
            }
//            System.out.println();
        }

        System.out.println("sum = " + sum);
    }
}
