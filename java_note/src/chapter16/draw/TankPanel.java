package chapter16.draw;

import javax.swing.*;
import java.awt.*;

public class TankPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 坦克颜色
        g.setColor(Color.blue);
        // 坦克左履带
        g.fillRect(0, 0, 5, 25);
        // 坦克右履带
        g.fillRect(15, 0, 5, 25);
        // 坦克身体
        g.fillRect(5, 5, 10, 15);
        // 坦克炮台
        g.fillOval(5,7,10,10);
        // 坦克炮筒
        g.drawLine(10,0,10,7);

        // 黑色描边
        g.setColor(Color.black);
        g.drawRect(0, 0, 5, 25);
        g.drawRect(15, 0, 5, 25);
        g.drawRect(5, 5, 10, 15);
        g.drawOval(5,7,10,10);
        g.drawLine(10,0,10,7);
    }
}
