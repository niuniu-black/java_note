package chapter06;

public class Homework07 {

    /*
    7.写出冒泡排序代码
     */

    public static void main(String[] args) {

        int[] arr = new int[10];

        // made arr
        System.out.println("arr is :");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // bubble sort
        System.out.println("bubble sort :");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + " times change :");
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // print the process of change
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

        // resout arr
        System.out.println("bubble sort result arr :");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
