package chapter13.homework04;

/*
4.编程题
输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 */
public class Homework04 {

    public static void main(String[] args) {
        String str = "asd1@23ASD";
        count(str);
    }

    public static void count(String str) {
        if (str == null) {
            System.out.println("str not null..");
            return;
        }


        int countNumber = 0;
        int countUpperCase = 0;
        int countLowerCase = 0;

//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] >= '0' && chars[i] <= '9') {
//                countNumber++;
//            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
//                countLowerCase++;
//            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
//                countUpperCase++;
//            }
//        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                countNumber++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                countLowerCase++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                countUpperCase++;
            }
        }

        System.out.println(str + " 中有 " + countUpperCase + " 个大写字母，有 " +
                countLowerCase + " 个小写字母，有 " + countNumber + " 个数字。");
    }
}
