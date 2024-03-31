package chapter13.homework01;

/*
1.编程题

 */

public class Homework01 {

    public static void main(String[] args) {

        String str = "abcdef";
        System.out.println("交换前：");
        System.out.println(str);
        try {
            str = reverse(str, 4, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("交换后：");
        System.out.println(str);
    }

    /**
     * (1)将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
     * (2)编写方法 public static String reverse(String str, int start , int end)搞定
     * 思路分析：
     * 1、先将 Srting 转换成 char[]
     *
     * @param str : 操作字符串
     * @param start : 操作开始位置
     * @param end : 操作结束位置
     * @return : 反转操作后的字符串
     */
    public static String reverse(String str, int start, int end) {

        // 对输入的参数做验证
        // 1、写出正确情况
        // 2、再取反即可
        if (!(str != null && start >= 0 && end > start && end <= str.length())) {
            throw new RuntimeException("参数不正确...");
        }

        char[] chars = str.toCharArray();

        char temp = ' ';
        for (int i = start - 1, j = end - 1; i < end && i <= j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
}
