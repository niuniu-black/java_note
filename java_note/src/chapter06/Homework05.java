package chapter06;

public class Homework05 {

    /*
    5.随机生成10个整数(1_100的范围)保存到数组，并倒序打印以及求平均值、求最大值和最大值的下标、并查找里面是否有8
     */

    public static void main(String[] args) {

//        int random = (int) (Math.random() * 100 + 1);
        int[] arr = new int[10];
        double sum = 0;
        double average = 0;
        int maxNum = 0;
        int maxNumIndex = -1;
        boolean isExist8 = false;

        // 随机生成10个1-100的整数，存到数组中
        System.out.println("正序打印：");
        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
            System.out.print(arr[i] + " ");

            // 求所有值的和
            sum += arr[i];

            // 求最大值及最大值的下标
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                maxNumIndex = i;
            }

            // 判断数组中是否有8
            if (arr[i] == 8) {
                isExist8 = true;
            }
        }
        System.out.println();

        // 倒序打印
        System.out.println("倒序打印：");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 求平均值
        average = sum / arr.length;
        System.out.println("average is " + average);

        // 最大值及最大值的下标
        System.out.println("最大值为：" + maxNum);
        System.out.println("最大值的下标为：" + maxNumIndex);

        // 是否存在8
        if (isExist8) {
            System.out.println("数组中存在8...");
        } else {
            System.out.println("数组中不存在8...");
        }
    }
}
