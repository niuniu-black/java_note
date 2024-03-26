package chapter08.Homework14;

public class Homework14 {

    public static void main(String[] args) {
        C c = new C();
    }
}

/*
14.程序阅读题在mian方法中执行:C c=new C();输出什么内容?
result:
我是A类
hahah我是B类的有参构造
我是c类的有参构造
我是c类的无参构造
 */

class A {
    public A() {  // 4.
        System.out.println("我是A类");  // 5.
    }
}

class B extends A {
    public B() {
        System.out.println("我是B类的无参构造");
    }

    public B(String name) {  // 3.  // 这里隐藏了父类的无参构造器，所以会去调用父类的无参构造器
        System.out.println(name + "我是B类的有参构造");  // 6.
    }
}

class C extends B {
    public C() {
        this("hello");  // 1.
        System.out.println("我是C类的无参构造");  // 7.
    }

    public C(String name) {
        super("hahah");  // 2.
        System.out.println("我是C类的有参构造");  // 8.
    }
}


