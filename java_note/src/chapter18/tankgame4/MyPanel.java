package chapter18.tankgame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区域
 */
// 为了监听键盘事件，实现 KeyListener
// 为了可以让子弹一直绘制，需要 MyPanel 实现 Runnable 接口，以一个单独的线程实现
public class MyPanel extends JPanel implements KeyListener, Runnable {

    MyTank myTank = null;
    // 定义敌人坦克，放入 Vector 里面，要保证线程安全
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        myTank = new MyTank(100, 100);  // 初始化自己坦克
//        myTank.setSpeed(1);  // 设置坦克移动速度
        // 初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            // 设置方向
            enemyTank.setDirect(2);
            // 给该 enemyTank 加入一颗子弹
//            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            Shot shot = new Shot(enemyTank);
            // 加入 enemyTank 的 Vector 成员
            enemyTank.shots.add(shot);
            // 启动 shot 对象
            new Thread(shot).start();

            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);  // 背景

        // 画出坦克-封装成方法
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 1);

        // 画出敌方坦克，遍历 Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            // 取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
            // 画出 enemyTank 所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                // 取出子弹
                Shot shot = enemyTank.shots.get(j);
                // 绘制
                if (shot.isLive()) {  // isLive == true
                    drawBullet(shot.getX(), shot.getY(), g, 0);
                } else {
                    // 从 Vector 移除
                    enemyTank.shots.remove(shot);
                }
            }
        }

        // 画出子弹-封装成方法
        if (myTank.getShot() != null && myTank.getShot().isLive()) {
            drawBullet(myTank.getShot().getX(), myTank.getShot().getY(), g, 1);
//            g.fillOval(myTank.getShot().getX(), myTank.getShot().getY(), 2, 2);
            System.out.println("bullet x=" + myTank.getShot().getX() + " y=" + myTank.getShot().getY());
        }
    }

    /**
     * 编写画坦克的方法
     *
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型  0-敌人的坦克  1-自己的坦克
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0:  // 敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 自己的坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克的方向，来绘制坦克
        // direct 表示方向(0-向上，1-向右，2-向下，3-向左)
        switch (direct) {
            case 0:  // 表示向上
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  // 画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);  // 画出坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);  // 画出坦克炮台
                g.drawLine(x + 20, y + 30, x + 20, y);  // 画出坦克的炮筒
                break;
            case 1:  // 表示向右
                g.fill3DRect(x, y, 60, 10, false);  // 画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  // 画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);  // 画出坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);  // 画出坦克炮台
                g.drawLine(x + 30, y + 20, x + 60, y + 20);  // 画出坦克的炮筒
                break;
            case 2:  // 表示向下
                g.fill3DRect(x, y, 10, 60, false);  // 画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);  // 画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);  // 画出坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);  // 画出坦克炮台
                g.drawLine(x + 20, y + 30, x + 20, y + 60);  // 画出坦克的炮筒
                break;
            case 3:  // 表示向右
                g.fill3DRect(x, y, 60, 10, false);  // 画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);  // 画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);  // 画出坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);  // 画出坦克炮台
                g.drawLine(x + 30, y + 20, x, y + 20);  // 画出坦克的炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    /**
     * 绘制子弹轨迹，从炮筒的的坐标开始
     *
     * @param x    子弹左上角坐标
     * @param y    子弹右上角坐标
     * @param g    画笔
     * @param type 坦克类型  0-敌人坦克的子弹  1-自己坦克的子弹
     */
    public void drawBullet(int x, int y, Graphics g, int type) {

        int bulletSize = 2;  // 子弹大小

        switch (type) {
            case 0:  // 敌人坦克的子弹
                g.setColor(Color.cyan);
                break;
            case 1: // 自己坦克的子弹
                g.setColor(Color.yellow);
                break;
        }
        g.fillOval(x, y, bulletSize, bulletSize);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理 wasd 键按下的情况
    // 处理 j 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {  // 按下 W 键, 向上
            // 改变坦克方向
            myTank.setDirect(0);
            // 修改坦克坐标
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {  // 按下 D 键，向右
            myTank.setDirect(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {  // 按下 S 键，向下
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {  // 按下 A 键， 向左
            myTank.setDirect(3);
            myTank.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {  // 按下 J 键，发射子弹
            myTank.tankShot(myTank);
//            System.out.println(Thread.currentThread().getName() + " 按下了 J 键...");
        }

        // 重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while (true) {  // 将面板放在单独的线程里，每隔100ms重绘一次
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
