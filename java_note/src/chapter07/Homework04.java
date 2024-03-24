package chapter07;

public class Homework04 {

    /*
    4.编写类AO3,实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
     */

    public static void main(String[] args) {

        Object[] arr = {'1', '2', "3", "4", 5, 5, 'a', "aaaa"};
        System.out.println("arr is ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        A03 a03 = new A03();

        Object[] newArr = new Object[arr.length];
        newArr = (Object[]) a03.copyArr(arr);

        System.out.println("newArr is ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        System.out.println();

    }
}

class A03 {

    public Object copyArr(Object[] oldArr) {
        Object[] newArr = new Object[oldArr.length];

        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        System.out.println("copy finished...");
        return newArr;
    }
}
