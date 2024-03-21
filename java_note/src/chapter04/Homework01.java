package chapter04;

public class Homework01 {

    /*
    计算下列表达式结果
    10/3 = ? ; 10/5 = ? ; 10%2 = ? ; -10.5%3 = ? ;
    答：
       3     ;      2   ;      0   ;        -1.5 ;
     */

    public static void main(String[] args) {

        System.out.println("10/3 = " + (10 / 3));
        System.out.println("10/5 = " + (10 / 5));
        System.out.println("10%2 = " + (10 % 2));
        // a % b 当 a 是小数时，公式 -> a - (int)a / b * b
        // 注意：有小数参与的运算，得到结果是近似值
        System.out.println("-10.5%3 = " + (-10.5 % 3));
    }
}
