package chapter07;

public class Homework01 {

    /*
    1.编写类A01，定义方法max，实现求某个double数组的最大值，并返回
     */

    public static void main(String[] args) {

        double[] arr = new double[10];
//        double max;
        Double max;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 100;
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        A01 a01 = new A01();
        max = a01.max(arr);

        if (max != null) {
            System.out.println("max = " + max);
        } else {
            System.out.println("arr 有误...数组不能为空，或者{}");
        }
    }
}

class A01 {

    // public double max(double[] arr) {
     public Double max(double[] arr) {  // Double 为包装类
         if (arr != null && arr.length > 0) {
             double max = 0;

             for (int i = 0; i < arr.length; i++) {
                 if (arr[i] > max) {
                     max = arr[i];
                 }
             }

             return max;
         } else {
             return null;
         }
    }
}
