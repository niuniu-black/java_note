package chapter19.homework02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
2.编程题
要求:使用BufferedReader读取一个文本文件，为每行加上行号再连同内容一并输出到屏幕上。
 */
public class Homework02 {

    public static void main(String[] args) {

        String filePath = "d:\\新建文本文档.txt";
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filePath));
            int i = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(++i + " " + line);
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
    }
}
