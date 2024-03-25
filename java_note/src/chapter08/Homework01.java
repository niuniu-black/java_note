package chapter08;

public class Homework01 {

    /*
    1.定义一个Person类 {name, age, job},初始化Person对象数组，有3个person对象，并按照age从大到小进行排序,提示，使用冒泡排序
     */

    static class Person {

        private String name;
        private int age;
        private String job;

        public Person(String name, int age, String job) {
            this.name = name;
            this.age = age;
            this.job = job;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public String getJob() {
            return job;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", job='" + job + '\'' +
                    '}';
        }
    }

    public static void bubbleSort(Person[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getAge() < arr[j + 1].getAge()) {
                    Person tempPerson = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempPerson;
                }
            }
        }

    }

    public static void main(String[] args) {

        int[] ageArr = new int[3];

        Person[] personArr = new Person[3];

        personArr[0] = new Person("A", 90, "aaaa");
        personArr[1] = new Person("B", 10, "bbbb");
        personArr[2] = new Person("C", 40, "cccc");

        System.out.println("排序前的顺序：");
        for (int i = 0; i < personArr.length; i++) {
            System.out.println(personArr[i]);
        }

        // 排序
        bubbleSort(personArr);

        System.out.println("排序后的顺序：");
        for (int i = 0; i < personArr.length; i++) {
            System.out.println(personArr[i]);
        }

    }

}

