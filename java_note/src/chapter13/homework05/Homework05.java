package chapter13.homework05;

/*
5.试写出以下运行结果
已知Animal类有属性name,可以通过有参构造为属性赋值
 */
public class Homework05 {

    public static void main(String[] args) {

        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a==b);  // false , a 和 b 是同一个类的两个不同的对象
        System.out.println(a.equals(b));  // false , a 和 b 是同一个类的两个不同的对象
        System.out.println(a.name==b.name);  // true , a 和 b 的 name 都指向常量池中的 "hspedu"

        String s4= new String("hspedu");
        String s5 = "hspedu";
        System.out.println(s1==s4);  // false , s1 是在常量池中的 String 常量，s4 是一个 String 对象
        System.out.println(s4==s5);  // false , s5 是在常量池中的 String 常量，s4 是一个 String 对象

        String t1 = "hello"+s1;
        String t2 = "hellohspedu";
        System.out.println(t1.intern()==t2);  // true , intern() 返回 string 在常量池中的地址

    }
}


class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}


