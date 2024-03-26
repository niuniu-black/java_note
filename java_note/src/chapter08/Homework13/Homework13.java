package chapter08.Homework13;

public class Homework13 {
    /*
    13.案例题目描述:
    (1)做一个Student类，Student类有名称(name)，性别(sex),年龄(age)，学号(stu_id)，做合理封装，通过构造器在创建对象时将4个属性赋值。
    (2)写一个Teacher类，Teacher类有名称(name)，性别(sex)，年龄(age)，工龄(work_age),做合理封装，通过构造器在创建对象时将4个属性赋值。
    (3)抽取一个父类Person类，将共同属性和方法放到Person类
    (4)学生需要有学习的方法(study)，在方法里写生“我承诺，我会好好学习。”。
    (5)教师需要有教学的方法(teach)，在方法里写上“我承诺，我会认真教学。”。
    (6)学生和教师都有玩的方法(play)，学生玩的是足球，老师玩的是象棋，此方法是返回字符串的，分别返回“xx爱玩足球”和“xx爱玩象棋”(其中xx分别
       代表学生和老师的姓名)。因为玩的方法名称都一样，所以要求此方法定义在父类中，子类实现重写。
    (7)定义多态数组，里面保存2个学生和2个教师，要求按年龄从高到低排序，
    (8)定义方法，形参为Person类型，功能:调用学生的study或教师的teach方法

    13.打印效果如下
    老师的信息:
    姓名:张飞
    年龄:30
    性别:男
    工龄:5
    我承诺，我会认真教课。
    张飞爱玩象棋
    ------------------------------
    学生的信息:
    姓名:小明
    年龄:15
    性别:男
    学号:00023102
    我承诺，我会好好学习。
    小明爱玩足球。

     */

    public static void main(String[] args) {

        Person[] personArr = new Person[4];

        personArr[0] = new Student("小明", '男', 15, "00023102");
        personArr[1] = new Student("小花", '女', 13, "00024112");
        personArr[2] = new Teacher("张飞", '男', 30, 5);
        personArr[3] = new Teacher("刘备", '男', 40, 15);

        // 排序
        sort(personArr);

        for (int i = 0; i < personArr.length; i++) {
            getPrintInfo(personArr[i]);
            System.out.println("-------------------------");
            getStudyOrTeach(personArr[i]);
            System.out.println("=========================");
        }

    }

    public static void sort(Person[] personArr) {  // 按照年龄从高到低排序
        Person temp = null;

        for (int i = 0; i < personArr.length; i++) {
            for (int j = 0; j < personArr.length - i - 1; j++) {
                if (personArr[j].getAge() < personArr[j + 1].getAge()) {
                    temp = personArr[j];
                    personArr[j] = personArr[j + 1];
                    personArr[j + 1] = temp;
                }
            }
        }
    }

    public static void getStudyOrTeach(Person person) {

        if (person instanceof Student) {
            ((Student) person).study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }
    }

    public static void getPrintInfo(Person person) {

        if (person instanceof Student) {
            ((Student) person).printInfo();
        } else if (person instanceof Teacher) {
            ((Teacher) person).printInfo();
        }
    }
}

class Person {

    private String name;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String play() {
        return (this.name + "爱玩");
    }

    public String basicInfo() {
        return ("姓名：" + getName() +
                "\n年龄：" + getAge() +
                "\n性别：" + getSex());
    }
}

class Student extends Person {

    private String stuId;
    private String hobby = "足球";

    public Student(String name, char sex, int age, String stuId) {
        super(name, sex, age);
        this.stuId = stuId;
    }

    public String getStuId() {
        return stuId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    @Override
    public String play() {
        return (super.play() + getHobby() + "。");
    }

    public void study() {
        System.out.println("I promise, I will study hard!");
    }

    public void printInfo() {
        System.out.println("学生的信息：");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + getStuId());
        study();
        System.out.println(play());
    }
}

class Teacher extends Person {

    private double workAge;
    private String hobby = "象棋";

    public Teacher(String name, char sex, int age, double workAge) {
        super(name, sex, age);
        this.workAge = workAge;
    }

    public double getWorkAge() {
        return workAge;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setWorkAge(double workAge) {
        this.workAge = workAge;
    }

    @Override
    public String play() {
        return (super.play() + getHobby() + "。");
    }

    public void teach() {
        System.out.println("I promise, I will teach hard!");
    }

    public void printInfo() {
        System.out.println("老师的信息：");
        System.out.println(super.basicInfo());
        System.out.println("工龄：" + getWorkAge());
        teach();
        System.out.println(play());
    }
}
