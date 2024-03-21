package chapter04;

import static com.Utils.getType;

public class Homework04 {

    /*
    试写出将 String 转换成 double 类型的语句，以及将 char 类型转换成 String 的语句，举例说明即可
     */

    public static void main(String[] args) {

        String str = "12.12";
        double d = Double.parseDouble(str);
        System.out.println(Double.parseDouble(str));
        System.out.println("Double.parseDouble(str) type is " + getType(Double.parseDouble(str)));

        char c = 'A';
        System.out.println(c + "");
        System.out.println("(c + \"\") type is " + getType((c + "")));

    }
}
