package chapter19.homework01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
1.编程题
(1)在判断e盘下是否有文件夹mytemp,如果没有就创建mytemp
(2)在e:\\mytemp 目录下,创建文件 hello.txt
(3)如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
(4)并且在hello.txt 文件中，写入 hello,world~
 */
public class Homework01 {

    public static void main(String[] args) throws IOException {

        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);

        if (!file.exists()) {
            // 创建
            if (file.mkdirs()) {
                System.out.println("创建 " + directoryPath + " 创建成功。");
            } else {
                System.out.println("创建 " + directoryPath + " 创建失败。");
                return;
            }
        }

        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);

        if (!file.exists()) {
            // 文件不存在就创建
            if (file.createNewFile()) {
                System.out.println(filePath + " 创建成功。");
            } else {
                System.out.println(filePath + " 创建失败。");
                return;
            }
        } else {
            System.out.println(filePath + "该文件已经存在");
        }

        // 如果文件存在，使用 BufferedWriter 字符输入流写入内容
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("hello world...啊啊啊");
        bufferedWriter.close();

    }

}
