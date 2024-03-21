package chapter03;

public class Homework02 {

    /*
    使用char类型，分别保存 \n \t \r \\ 1 2 3 等字符，并打印输出
     */

    public static void main(String[] args) {

        char wrap = '\n';  // 换行
        char c2 = '\t';  // 制表符
        char enter = '\r';  // 回车
        char c4 = '\\';  // 一个 \ 为转义字符，第二个 \ 输出
        char c5 = '1';  // 输出字符1
        char c6 = '2';  // 输出字符2
        char c7 = '3';  // 输出字符3

        System.out.println(wrap);
        System.out.println(c2);
        System.out.println(enter);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
    }
}
