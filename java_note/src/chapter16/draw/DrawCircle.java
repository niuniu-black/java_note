package chapter16.draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCircle extends JFrame {  // JFrame 对应窗口，可以理解成一个画框

    // 定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {

        new DrawCircle();

    }

    public DrawCircle() {  // 构造器
        // 初始化面板
        mp = new MyPanel();
        // 把面板放入到窗口(画框)
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置点击窗口的关闭按钮，可以结束运行
        this.setVisible(true);  // 可以显示

    }
}

// 1. 先定义一个 MyPanel，继承 JPanel 类，画图形，就在面板上画
class MyPanel extends JPanel {

    // 说明：
    // 1、MyPanel 对象就是一个画板
    // 2、Graphics g 把 g 理解成一支画笔
    // 3、Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {  // 绘图方法，该方法会在窗口变化时和第一次显示的时候会自动调用该方法
        super.paint(g);  // 调用父类的方法完成初始化
        // 画出一个圆形
//        g.drawOval(10, 10, 100, 100);

        // 演示常用方法
        //画直线 drawLine(int x1,int y1,int x2,int y2)
//        g.drawLine(10, 20, 100, 100);
        //画矩形边框 drawRect(int x, int y, int width, int height)
//        g.drawRect(10, 10, 100, 150);
        //画椭圆边框 drawOval(int x,int y, int width, int height)
//        g.drawOval(10, 10, 100, 150);
        //填充矩形 fillRect(int x, int y, int width, int height)
        //设置画笔的颜色 setColor(Color c)
//        g.setColor(Color.blue);
//        g.fillRect(10, 10, 100, 120);
        //填充椭圆 fillOval(int x, int y, int width, int height)
//        g.setColor(Color.red);
//        g.fillOval(10,10,100,100);
        //画图片 drawImage(lmage img, int x, int y, ..)
        // 1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源, 图片放到out下chapter16 目录下
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/chapter16/1.jpg"));
        // 这种写法，需要把图片放到 DrawCircle.java 同级目录中
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("bg.png"));
//        g.drawImage(image, 10, 10, 175, 221, this);
        //画字符串 drawString(String str, int x, int y) , x 和 y 是 str 的左下角坐标
        //设置画笔的颜色 setColor(Color c)
        g.setColor(Color.blue);
        //设置画笔的字体 setFont(Font font)
        g.setFont(new Font("隶书", Font.BOLD, 50));
        g.drawString("北京你好", 100, 100);

    }
}

