package chapter02;

import java.util.Scanner;

public class Homework02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入性别：");
        String gender = scanner.next();
        System.out.println("请输入籍贯：");
        String origin = scanner.next();
        System.out.println("请输入住址：");
        String address = scanner.next();

        if (gender != "男" || gender != "女") {
            gender = "未知";
        }

        System.out.println(
                "个人基本信息：" +
                        "\n姓名：" + name +
                        "\n性别：" + gender +
                        "\n籍贯：" + origin +
                        "\n住址：" + address
        );
    }
}
