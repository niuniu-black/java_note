package chapter16.draw;

import javax.swing.*;

public class DrawTank extends JFrame {

    private TankPanel tankPanel = null;

    public static void main(String[] args) {
        new DrawTank();
    }

    public DrawTank() {
        // 初始化面板
        tankPanel = new TankPanel();
        // 把面板放入到窗口(画框)
        this.add(tankPanel);
        // 设置窗口的大小
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置点击窗口的关闭按钮，可以结束运行
        this.setVisible(true);  // 可以显示
    }
}
