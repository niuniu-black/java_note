package chapter18.tankgame4;

/**
 * 为了让子弹可以以一个单独的线程在面板上绘制，定义一个类实现 Runnable 接口
 */
public class Shot implements Runnable {

    private int x;  // 子弹横坐标
    private int y;  // 子弹纵坐标
    private int direct;  // 子弹方向 0-up 1-right 2-down 3-left
    private int speed = 2;  // 控制子弹速度
    private boolean isLive = true;  // 子弹是否存活

    // 需要坦克对象
    Tank tank = null;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 构造器
    public Shot(Tank tank) {
        this.tank = tank;
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {

        // 获取坦克对象后，初始化子弹初始位置和方向
        direct = tank.getDirect();
        switch (direct) {
            case 0:  // 表示向上，坦克炮筒坐标 (x+20,y+30 -> x+20,y)
                x = tank.getX() + 20;
                y = tank.getY();
                break;
            case 1:  // 表示向右，坦克炮筒坐标 (x+30,y+20 -> x+60,y+20)
                x = tank.getX() + 60;
                y = tank.getY() + 20;
                break;
            case 2:  // 表示向下，坦克炮筒坐标 (x+20,y+30 -> x+20,y+60)
                x = tank.getX() + 20;
                y = tank.getY() + 60;
                break;
            case 3:  // 表示向左，，坦克炮筒坐标 (x+30,y+20 -> x,y+20)
                x = tank.getX();
                y = tank.getY() + 20;
                break;
        }

        while (true) {
            System.out.println("x=" + x + " y=" + y);
            // 子弹到超过缘后，线程销毁，实现子弹打到边界就消失
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;  // 改变子弹存货状态
                break;
            }
            // 子弹沿当前方向移动
            switch (direct) {
                case 0:  // 表示子弹向上射击
                    y -= speed;
                    break;
                case 1:  // 表示子弹向右射击
                    x += speed;
                    break;
                case 2:  // 表示子弹向下射击
                    y += speed;
                    break;
                case 3:  // 表示子弹向左射击
                    x -= speed;
                    break;
            }
            // 休眠
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " shot exit..");

    }
}
