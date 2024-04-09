package chapter19.homework03;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/*
编程题
(1)要编写一个dog.properties
name=tom
age=5
color=red
(2)编写Dog 类(name,age,color)创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化，并输出
(3)将创建的Dog 对象 ，序列化到 文件 dog.dat 文件
 */
public class Homework03 {

    public static void main(String[] args) throws IOException {

        String propertiesPath = "F:\\xxx\\src\\chapter19\\homework03\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(propertiesPath));
//        System.out.println(properties);
        String name = properties.get("name") + "";  // Object -> String
        int age = Integer.parseInt((properties.get("age") + ""));  // Object -> int
        String color = properties.get("color") + "";  // Object -> String

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        // 序列化
        String outputPath = "src\\chapter19\\homework03\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath));
        oos.writeObject(dog);
        oos.close();
        System.out.println("序列化结束");
    }

    // 编写一个方法，返回序列化 dog
    @Test
    public void test() throws IOException, ClassNotFoundException {
        String serFilePath = "src\\chapter19\\homework03\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog) ois.readObject();
        ois.close();
        System.out.println("反序列化得到 dog 信息：");
        System.out.println(dog);
    }

    // 愚蠢的方法
    public void otherMethod() {
        String propertiesPath = "F:\\xxx\\src\\chapter19\\homework03\\dog.properties";
        BufferedReader br = null;
        Dog dog = null;
        String line = "";
        String name = "";
        int age = -1;
        String color = "";

        try {
            br = new BufferedReader(new FileReader(propertiesPath));
            while ((line = br.readLine()) != null) {
                switch (line.split("=")[0]) {
                    case "name":
                        name = line.split("=")[1];
                        break;
                    case "age":
                        age = Integer.parseInt(line.split("=")[1]);
                        break;
                    case "color":
                        color = line.split("=")[1];
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (name != null && age != -1 && color != null) {
            dog = new Dog(name, age, color);
        }

        System.out.println(dog);

        String outPutPath = "F:\\xxx\\src\\chapter19\\homework03\\dog.dat";
        File file = new File(outPutPath);

        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    // 创建成功，写内容
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(dog.toString());
                    bw.close();
                }
            } else {  // 文件存在，写内容
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(dog.toString());
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Dog implements Serializable {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

