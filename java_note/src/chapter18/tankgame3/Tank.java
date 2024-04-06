package chapter18.tankgame3;

public class Tank {

    private int x;  // 坦克横坐标
    private int y;  // 坦克纵坐标
    private int direct;  // 坦克方向 0-up 1-right 2-down 3-left
    private int speed = 1;  // 控制坦克速度

    // 定义射击对象
    private Shot shot = null;

    // 坦克射击方法
    public void tankShot(Tank tank) {
//        Shot shot = new Shot(tank);  // 这里新定义了一个变量，导致类属性 shot 没有被赋值，所以无法被绘制
        shot = new Shot(tank);
        new Thread(shot).start();
    }

    // 上右下左移动方法
    public void moveUp() {
        y -= speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveLeft() {
        x -= speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shot getShot() {
        return shot;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
