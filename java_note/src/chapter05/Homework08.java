package chapter05;

public class Homework08 {

    /*
    8.求出1-1/2+1/3-1/4.....1/100的和
     */

    public static void main(String[] args) {

        double sum = 0;


        for (int i = 1; i <= 100; i++) {
//            sum += Math.pow(-1, i - 1) * (1.0 / i);
////            System.out.println(Math.pow(-1, i - 1) * (1.0 / i));
            if (i%2 != 0) {  // 分母为奇数
                sum += 1.0/i;
            } else {  // 分母为偶数
                sum -= 1.0/i;
            }
        }

        System.out.println("sum = " + sum);
    }
}
