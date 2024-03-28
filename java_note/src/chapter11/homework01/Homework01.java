package chapter11.homework01;

/*
8.编程题
枚举类I
1．创建一个Color枚举类
2.有RED,BLUE,BLACK, YELLOW,GREEN这个五个枚举值/对象;3.Color有三个属性redValue,greenValue,blueValue,
4.创建构造方法，参数包括这三个属性，
5、每个枚举值都要给这三个属性赋值，三个属性对应的值分别是
6. red: 255,0,0 blue:0,0,255 black:0,0,0 yellow:255,255,0 green:0,255,07、定义接口，里面有方法show，要求Color实现该接口
8. show方法中显示三属性的值
9．将枚举对象在switch语句中匹配使用
 */
public class Homework01 {

    public static void main(String[] args) {
        Color color = Color.RED;
        color.show();

        // switch () 中，放入枚举对象
        // 在每个 case 后，直接写上在枚举类中，定义的美剧对象即可
        switch (color) {
            case RED:
                System.out.println("color is red...");
                break;
            case BLACK:
                System.out.println("color is black...");
                break;
            case BLUE:
                System.out.println("color is blue...");
                break;
            case YELLOW:
                System.out.println("color is yello...");
                break;
            case GREEN:
                System.out.println("color is green...");
                break;
        }
    }
}

enum Color implements ShowColor {

    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为：");
        System.out.println("red =" + getRedValue());
        System.out.println("green =" + getGreenValue());
        System.out.println("blue =" + getBlueValue());
    }
}

interface ShowColor {
    public void show();
}
