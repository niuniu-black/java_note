import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello java, 你好~~");

        Scanner myscanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
    }
}

// 查看勒的继承关系  ctrl + H
class Person {
    String name;
    int age;

    // 构造器-快捷键 -> alt + insert

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
