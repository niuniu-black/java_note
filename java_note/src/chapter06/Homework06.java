package chapter06;

public class Homework06 {

    /*
    6.试写出以下代码的打印结果HomeworkO6.javachar[arr1=f'a",'z,b";'C';
    答：
    a,a
    z,z
    李,李
    c,c
     */

    public static void main(String[] args) {

        char[] arr1 = {'a', 'z', 'b', 'c'};
        char[] arr2 = arr1;
        arr1[2] = '李';

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr1[i] + "," + arr2[i]);
        }
    }
}
