package chapter08;

public class Homework11 {

    /*
    11.现有Person类，里面有方法run、eat,Student类继承了Person类 并重写了run方法，自定义了study方法,
    试写出对象向上转型和向下转型的代码，并写出各自都可以调用哪些方法,并写出方法输出什么?

    result:

     */

    static class Person {
        public void run() {
            System.out.println("person run");
        }

        public void eat() {
            System.out.println("person eat");
        }
    }

    static class Student extends Person {
        public void run() {
            System.out.println("student run");
        }

        public void study() {
            System.out.println("student study..");
        }
    }

    public static void main(String[] args) {

        Student student = new Student();
        student.run();
        student.eat();  // Person -> eat()
        student.study();

        System.out.println("student to person...");
        // 向上转型，父类的引用指向子类对象
        Person studentToPerson = (Person) student;  // 编译类型看 = 左边对象，运行类型看 = 右边对象。
        // Person 类中只有 run() eat() 方法，所以只能调用 run() eat() 方法
        // 运行的时候是 Student 对象，所以从 Student 类中查找 run() eat() 方法， run() 方法在 Student 类中重写了，所以就近调用
        //     eat() 方法在 Student 类中没有，所以向父类中查找，找到后，调用父类中的 eat() 方法
        studentToPerson.run();  // student run
        studentToPerson.eat();  // person eat

        System.out.println("student to person to student...");
        // 向下转型，把指向子类对象的父类引用，转成指向子类对象的子类引用
        Student studentToPersonToStudent = (Student) studentToPerson;
        studentToPersonToStudent.run();  // student run
        studentToPersonToStudent.eat();  // person eat
        studentToPersonToStudent.study();  // student study..
    }

}
