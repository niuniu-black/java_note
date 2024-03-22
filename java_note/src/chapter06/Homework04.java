package chapter06;

public class Homework04 {

    /*
    4.已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序,比如:[10, 12, 45, 90]，添加23后，数组为[10，12，23，45，90]
     */

    public static void main(String[] args) {

        int[] arr = {10, 12, 45, 90};
        int insertNum = 23;

//        System.out.println(arr.length);

//        // 方法一：
//        int[] newArr = new int[arr.length + 1];
//        for (int i = 0, j = 0; i < newArr.length; i++) {
//
//            if (j < arr.length) {
//                if (arr[j] <= insertNum) {
//                    newArr[i] = arr[j];
//                    j++;
//                } else if (insertNum <= arr[j]) {
//                    newArr[i] = insertNum;
//                    insertNum = arr[arr.length - 1];
//                }
//            } else {  // 当insertNum大于原数组最大的数时，将insertNum放在最后一个。避免数组越界
//                 newArr[i] = insertNum;
//            }
//        }

        // 方法二：
        int index = -1;  // index 记录 insertNum 需要被插入位置的索引
        for (int i = 0; i < arr.length; i++) {
            if (insertNum <= arr[i]) {
                index = i;
                break;
            }
        }
        // 判断 index 的值
        if (index == -1) {  // 说明没有找到位置，说明需要插入的数比原先数组中所有的数都大，要将insertNum插入到新数组的最后
            index = arr.length;
        }
        // 扩容创建一个新的数组
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {

            if (i != index) {  // 说明可以把 arr 的元素拷贝到 newArr
                newArr[i] = arr[j];
                j++;
            } else {  // i 这个位置就是要插入的数
                newArr[i] = insertNum;
            }
        }

        // 让 arr 指向 newArr ，原来的数组，成为垃圾，被销毁
        arr = newArr;
        // 遍历 arr
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
