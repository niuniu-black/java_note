package chapter12.homework02;

public class Homework02 {

    /*
    2说出以下代码是否会发生异常，如果会，是哪种异常?如果不会，则打印结果是什么
     */
    public static void main(String[] args) {

        // ArrayIndexOutOfBoundsException 参数个数不对，数组越界异常异常
        // NullPointerException 参数不存在，空指针异常
        // NumberFormatException 参数格式异常
        if (args[4].equals("john")) {
            System.out.println("AA");
        }else{
            System.out.println("BB");
        }
        Object o = args[2];  // String -> Object  向上转型
        // ClassCastException 类型转换异常
        Integer i = (Integer) o;
    }

}
