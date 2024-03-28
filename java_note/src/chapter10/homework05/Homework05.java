package chapter10.homework05;

/*
5.编程题HomeworkO5.java
内部类
1．编一个类A，在类中定义局部内部类B，B中有一个私有常量name，有一个方法show()打印常量name。进行测试
2、进阶:A中也定义一个私有的变量name，在show方法中打印测试
 */
public class Homework05 {

    public static void main(String[] args) {

        new A().f1();
    }
}

class A {

    private String name = "A";

    public void f1() {

        class B {  // 局部内部类

            private final String name = "B";

            public void show() {
                // 如果内部类和外部类属性重名，可以用 外部类名.this.属性名 来指定
                System.out.println("B name is " + name + "; 外部类 A name is " + A.this.name);
            }
        }

        B b = new B();
        b.show();
    }

}
