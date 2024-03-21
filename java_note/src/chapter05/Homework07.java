package chapter05;

public class Homework07 {

    /*
    7.输出小写的a-z以及大写的Z-A
     */

    public static void main(String[] args) {

        char c = 'a';
        char C = 'A';

//        for (int i = 0; i < 26; i++) {
//            System.out.print((char)(c + i) + " ");
//        }
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            System.out.print(c1 + " ");
        }
        System.out.println();

//        for (int i = 0; i < 26; i++) {
//            System.out.print((char)(C + i) + " ");
//        }
        for (char c2 = 'Z'; c2 >= 'A'; c2--) {
            System.out.print(c2 + " ");
        }
        System.out.println();
    }
}
