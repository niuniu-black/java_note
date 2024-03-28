package chapter10.homework07;

/*
7.编程题
内部类练习
有一个Car类，有属性temperature(温度)，车内有Air(空调）类，有吹风的功能flow,Air会监视车内的温度，如果温度超过40度则吹冷气。
如果温度低于0度则吹暖气，如果在这之间则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确.
 */
public class Homework07 {

    public static void main(String[] args) {

        Car car1 = new Car(-1);
        car1.getAir().flow();

        Car car2 = new Car(20);
        car2.getAir().flow();

        Car car3 = new Car(41);
        car3.getAir().flow();

    }
}

class Car {
    private static double temperature;  // 温度


    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {

        public void flow() {
            if (Car.temperature < 0) {
                System.out.println("当前车内温度为 " + Car.temperature + " ,小于0℃，吹暖风...");
            } else if (Car.temperature > 40) {
                System.out.println("当前车内温度为 " + Car.temperature + " ,大于40℃，吹冷风...");
            } else {
                // 关闭空调
                System.out.println("当前车内温度为 " + Car.temperature + " ,温度适宜，将关闭空调...");
                offAir();
            }
        }

        public void offAir() {
            System.out.println("空调已关闭...");
        }
    }

    // 返回内部类对象
    public Air getAir() {
        return new Air();
    }
}
