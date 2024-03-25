package chapter08;

public class Homework03 {

    /*
    3.编写老师类
    (1)要求有属性“姓名name”，“年龄age”，“职称post”，“基本工资salary"
    (2)编写业务方法,introduce () ，实现输出一个教师的信息。
    (3)编写教师类的三个子类:教授类(Professor )、副教授类、讲师类。工资级别分别为:教授为1.3、副教授为1.2、讲师类1.1。
       在三个子类里面都重写父类的introduce()方法。
    (4)定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印.
     */

    static class Teacher {

        private String name;
        private int age;
        private String post;
        private double salary;

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

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Teacher(String name, int age, String post, double salary) {
            this.setName(name);
            this.setAge(age);
            this.setPost(post);
            this.setSalary(salary);
        }

        public void introduce() {
            System.out.println("教师基本信息：\n" +
                    "姓名：" + this.getName() + "\n" +
                    "年龄：" + this.getAge() + "\n" +
                    "职称：" + this.getPost() + "\n" +
                    "基本工资：" + this.getSalary() + "\n"
            );
        }

    }

    static class Professor extends Teacher {

        public Professor(String name, int age, String post, double salary) {
            super(name, age, post, salary);
        }

        @Override
        public void introduce() {
            // 教授工资级别为 1.3
            double payScale = 1.3;
            System.out.println("教授基本信息：\n" +
                    "姓名：" + this.getName() + "\n" +
                    "年龄：" + this.getAge() + "\n" +
                    "职称：" + this.getPost() + "\n" +
                    "基本工资：" + (this.getSalary() * payScale) + "\n"
            );
        }
    }

    static class AssistantProfessor extends Teacher {

        public AssistantProfessor(String name, int age, String post, double salary) {
            super(name, age, post, salary);
        }

        @Override
        public void introduce() {
            // 副教授工资级别为 1.2
            double payScale = 1.2;
            System.out.println("副教授基本信息：\n" +
                    "姓名：" + this.getName() + "\n" +
                    "年龄：" + this.getAge() + "\n" +
                    "职称：" + this.getPost() + "\n" +
                    "基本工资：" + (this.getSalary() * payScale) + "\n"
            );
        }
    }

    static class Lecturer extends Teacher {

        public Lecturer(String name, int age, String post, double salary) {
            super(name, age, post, salary);
        }

        @Override
        public void introduce() {
            // 讲师工资级别为 1.1
            double payScale = 1.1;
            System.out.println("讲师基本信息：\n" +
                    "姓名：" + this.getName() + "\n" +
                    "年龄：" + this.getAge() + "\n" +
                    "职称：" + this.getPost() + "\n" +
                    "基本工资：" + (this.getSalary() * payScale) + "\n"
            );
        }
    }

    public static void main(String[] args) {

        Teacher teacher = new Professor("L", 25, "professor", 30000);

        teacher.introduce();

    }

}
