package chapter08;

public class Homework07 {

    /*
    7.写出程序结果
    resule:
    Test
    Demo
    Rose
    Jack
    john
    Jack
     */

    static class Test {
        String name = "Rose";

        Test() {
            System.out.println("Test");
        }

        Test(String name) {
            this.name = name;
        }
    }

    static class Demo extends Test {
        String name = "Jack";

        Demo() {
            super();
            System.out.println("Demo");
        }

        Demo(String s) {
            super(s);
        }

        public void test() {
            System.out.println(super.name);
            System.out.println(this.name);
        }

        public static void main(String[] args) {
            new Demo().test();
            new Demo("john").test();
        }
    }

}
