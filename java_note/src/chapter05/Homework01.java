package chapter05;

public class Homework01 {

    /*
    1.编程实现如下功能
    某人有100,000元，每经过一次路口，需要交费，规则如下：
    1)当现金>50000时，每次交5%
    2)当现金<=50000时，每次交1000
    编程计算该人可以经过多少次路口,要求:使用while break方式完成
     */

    public static void main(String[] args) {
        double deposit = 100000.0;
        int count = 0;  // 统计经过次数
        while (true) {
            if (deposit > 50000) {
//                deposit = deposit - deposit * 0.05;
                deposit *= 0.95;
//            } else if (deposit <= 50000 && deposit >= 1000) {
            } else if (deposit >= 1000) {
//                deposit = deposit - 1000;
                deposit -= 1000;
            } else {
                break;
            }
            count++;
        }

        System.out.println("100000元可以经过" + count + "次路口。");
    }
}
