package chapter05;

import java.util.Scanner;

public class Homework04 {

    /*
    4.判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。例如:153 = 1*1*1 +3*3*3 +5*5*5
    三位的水仙花数共有4个：153，370，371，407；
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.next();
            try {
                int i = Integer.parseInt(str);

                if (i < 10000 && i >= 100) {
                    int bai = i / 100;
//                    int shi = (i - 100 * bai) / 10;
                    int shi = i % 100 /10;
//                    int ge = (i - 100 * bai) % 10;
                    int ge = i % 10;
                    System.out.println("百位：" + bai + " 十位：" + shi +" 个位：" + ge);
                    if (Math.pow(bai, 3) + Math.pow(shi, 3) + Math.pow(ge, 3) == i) {
                        System.out.println(i + "是一个水仙花数...");
                    } else {
                        System.out.println(i + "不是一个水仙花数...");
                    }
                } else {
                    System.out.println("请输入一个三位数...");
                }
            } catch (Exception e) {
                if (str.equals("q")) {
                    System.out.println("退出...");
                    break;
                }
                System.out.println("输入的不是数...请输入一个三位数...");
            }
            System.out.println("可输入q退出...");
        }
    }
}
