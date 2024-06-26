package chapter16.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {

    MyTank myTank = null;

    public MyPanel() {
        myTank = new MyTank(100, 100);  // 初始化自己坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        // 画出坦克-封装成方法
        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);
    }

    /**
     * 编写画坦克的方法
     *
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型  0-自己的坦克  1-敌人的坦克
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0:  // 自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克的方向，来绘制坦克
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  // 画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);  // 画出坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);  // 画出坦克炮台
                g.drawLine(x + 20, y + 30, x + 20, y);  // 画出坦克的炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
