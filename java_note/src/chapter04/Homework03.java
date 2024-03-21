package chapter04;

import static com.Utils.getType;

public class Homework03 {

    /*
    在Java中，一下赋值语句正确的是 (C , D)
    A) int num1 = (int)"18";  // ❌ ，字符串转正数需要用到String对应的方法，Integer.parselnt("18");
    B) int num2 = 18.0;  // ❌ ，double 不能赋给int
    C) double num3 = 3d;  // ✔ ，d表示double类型
    D) double num4 = 8;  // ✔ ，int -> double
    E) int i = 48; char ch = i + 1;  // ❌ ，int不能赋给char
    F) byte b = 19; short s = b + 2;  // ❌ ，int不能赋给short
     */

    public static void main(String[] args) {
        byte b1 = 10;
        short s1 = 10;
        char c1 = 'a';

        System.out.println(b1 + s1 + c1);
        System.out.println("b1 + s1 + c1 type is " + getType((b1 + s1 + c1)));
        System.out.println("b1 type is " + getType(b1));

    }


}
