package chapter05;

import java.util.Scanner;

public class Homework02 {

    /*
    2.实现判断一个整数，属于哪个范围:大于0;小于0;等于0
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
//            // 需要保证输入为数字时，可用下面代码
//            double i = scanner.nextDouble();
            // 若不能保证输入为数字时，可以先用string接收，再转为double
            String str = scanner.next();
            try {
                double i = Double.parseDouble(str);

                if (i > 0) {
                    System.out.println("输入的数为：" + i + "，大于0");
                } else if (i < 0) {
                    System.out.println("输入的数为：" + i + "，小于0");
                } else if (i == 0) {
                    System.out.println("输入的数为：" + i + "，等于0");
                }
            } catch (Exception e) {
                if (str.equals("q")) {
                    System.out.println("退出...");
                    break;
                }
                System.out.println("输入的不是一个数...请输入数字...");
            }
            System.out.println("可输入q退出...");
        }

    }
}
