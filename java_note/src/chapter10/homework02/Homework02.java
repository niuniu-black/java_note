package chapter10.homework02;

public class Homework02 {

    /*
    2.编程题
    1．在Frock类中声明私有的静态属性currentNum[int类型]，初始值为100000，作为衣服出
    厂的序列号起始值。
    2．声明公有的静态方法getNextNum，作为生成上衣唯一序列号的方法。每调用一次，将
    currentNum增加100，并作为返回值。
    3.在TestFrock类的main方法中，分两次调用getNextNum方法，获取序列号并打印输出。4、在Frock类中声明serialNumber(序列号)属性，并提供对应的get方法;
    5.在Frock类的构造器中，通过调用getNextNum方法为Frock对象获取唯一序列号，赋给
    serialNumber属性。
    6.在TestFrock类的main方法中，分别创建三个Frock对象，并打印三个对象的序列号，验
    证是否为按100递增。
     */

    public static void main(String[] args) {

        System.out.println("第一次调用 getNextNum 方法后，序列号为：" + Frock.getNextNum());  // 100100
        System.out.println("第二次调用 getNextNum 方法后，序列号为：" + Frock.getNextNum());  // 100200

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();

        System.out.println("frock1 Serial Number is " + frock1.getSerialNumber());  // 100300
        System.out.println("frock2 Serial Number is " + frock2.getSerialNumber());  // 100400
        System.out.println("frock3 Serial Number is " + frock3.getSerialNumber());  // 100500

    }
}
