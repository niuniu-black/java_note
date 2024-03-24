package chapter07;

public class Homework12 {

    /*
    12.创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造方法，可以初始化
    (1)(名字，性别，年龄，职位，薪水).
    (2)(名字，性别,年龄)
    (3)(职位，薪水)，要求充分复用构造器
     */
}

class Employee {

    String name;
    char gender;
    int age;
    String position;
    double salary;

    // 因为要求可以复用构造器，因此先写属性少的构造器
    public Employee(String position, double salary) {
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Employee(String name, char gender, int age, String position, double salary) {
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
        this(name, gender, age);  // 使用到前面的构造器，可以复用，但是this()语法只能出现在第一行
        this.position = position;
        this.salary = salary;
    }
}
