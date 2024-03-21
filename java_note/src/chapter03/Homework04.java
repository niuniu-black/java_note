package chapter03;

public class Homework04 {

    /*
    编程实现如下效果
    姓名    年龄    成绩    性别    爱好
    xx      xx     xx      xx     xx
     */
    public static void main(String[] args) {

        String name = "蔡徐坤";
        int age = 20;
        float grades = 90;
        char gender = '男';
        String hobbies = "唱，跳，rap，篮球";

        System.out.println("姓名\t年龄\t成绩\t性别\t爱好\n" +
                name + "\t" + age + "\t" + grades + "\t" + gender + "\t" + hobbies);
    }
}
