package chapter08;

import java.util.Objects;

public class Homework10 {

    /*
    10.编写Doctor类 {name, age, job, gender, sal}相应的getter()和setter()方法，5个参数的构造器，
       重写父类的equals()方法: public boolean equals(Object obj)，并判断测试类中创建的两个对象是否相等。相等就是判断属性是否相同
     */

    static class Doctor {

        private String name;
        private int age;
        private String job;
        private char gender;
        private double sal;

        public Doctor(String name, int age, String job, char gender, double sal) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.gender = gender;
            this.sal = sal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public double getSal() {
            return sal;
        }

        public void setSal(double sal) {
            this.sal = sal;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;  // 判断两个对象是否相同
            if (!(obj instanceof Doctor)) return false;  // 判断 obj 是否是 Doctor 类型或其子类
            Doctor doctor = (Doctor) obj;  // 向下转型，因为 obj 的运行类型是 Doctor 或者其子类
            return age == doctor.age && gender == doctor.gender && Double.compare(doctor.sal, sal) == 0 &&
                    Objects.equals(name, doctor.name) && Objects.equals(job, doctor.job);
        }

    }

    public static void main(String[] args) {

        Doctor doctor1 = new Doctor("tom", 2, "cat", 'm', 100);
        Doctor doctor2 = new Doctor("tom", 2, "cat", 'w', 100);

        System.out.println(doctor1.equals(doctor2));
    }
}
