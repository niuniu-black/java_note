package chapter12.homework01;

/*
1.编程题
a)编写应用程序，接收命令行的两个参数(整数)，计算两数相除。
b)计算两个数相除，要求使用方法cal(int n1, int n2)
c)对数据格式不正确(NumberFormatException)、缺少命令行参数(ArrayIndexOutOfBoundsException)、除0进行异常(ArithmeticException)处理
 */
public class Homework01 {

    public static void main(String[] args) {

        try {
            // 判断接收命令行参数个数是否正确
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对...");
            }
            // 将命令行收到的参数，转成整数. 可能存在格式转换错误问题NumberFormatException
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2);  // 该方法可能抛出ArithmeticException

            System.out.println("计算结果是 = " + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不对，需要输入整数...");
        } catch (ArithmeticException e) {
            System.out.println("出现了除0的异常...");
        }

    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }

}
