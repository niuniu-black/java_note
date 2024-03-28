package chapter10.homework01;

class Car {
    double price = 10;
    static String color = "white";  // 静态对象只会在类加载时初始化一次，再次new对象，也不会变

    public String toString() {
        return price + "\t" + color;
    }

    public Car() {
        this.price = 9;
        this.color = "red";
    }

    public Car(double price) {
        this.price = price;
    }
}
