package chapter18.tankgame4;

import javax.swing.*;

public class TankGame04 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame04 tankGame01 = new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);  // 背景
        this.addKeyListener(mp);  // 监听 mp 的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
