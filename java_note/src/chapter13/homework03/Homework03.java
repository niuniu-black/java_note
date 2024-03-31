package chapter13.homework03;

/*
3.编程题
(1)编写java程序，输入形式为: Han shun Ping的人名，以Ping,Han .S的形式打印出来。其中.S是中间单词的首字母。
(2)例如输入“Willian Jefferson Clinton”，输出形式为: Clinton, Willian .J
 */
public class Homework03 {

    public static void main(String[] args) {

        String name = "Willian Jefferson Clinton";

        printName(name);

    }

    /**
     * 思路分析：
     * 1、对输入的字符串进行分割 split(" ")
     * 2、对得到的 String[] 进行格式化 String.format()
     * 3、对输入的字符串进行校验即可
     *
     * @param str : 传入改变前的字符串
     */
    public static void printName(String str) {

        if (str == null) {
            System.out.println("str not null...");
            return;
        }

        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("string format error...");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
