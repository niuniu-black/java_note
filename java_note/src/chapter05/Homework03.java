package chapter05;

import java.util.Scanner;

public class Homework03 {

    /*
    3.判断一个年份是否为闰年
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.next();
            try {
                int year = Integer.parseInt(str);

                if (((year % 4) == 0 && (year % 100) != 0) || ((year % 400) == 0)) {
                    System.out.println(year + "年是闰年...");
                } else {
                    System.out.println(year + "年不是闰年...");
                }
            } catch (Exception e) {
                if (str.equals("q")) {
                    System.out.println("退出...");
                    break;
                }
                System.out.println("输入的不是一个年份...请输入年份...");
            }
            System.out.println("可输入q退出...");
        }
    }
}
