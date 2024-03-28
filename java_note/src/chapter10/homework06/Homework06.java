package chapter10.homework06;

/*
6.编程题Homework06.java
1.有一个交通工具接口类Vehicles,有work方法
2.有Horse类和Boat类分别实现Vehicles
3．创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
4、有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5．实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
6.增加一个情况，如果唐僧过火焰山，使用飞机==>程序扩展性，我们前面的程序结构就非常好扩展
 */
public class Homework06 {

    public static void main(String[] args) {


        Person person = new Person("唐僧", new Horse());
        person.common();  // 一般情况下
        person.passRiver();  // 过河时
        person.passFireMountain();  // 过火焰山时
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("horse work...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("boat work...");
    }
}

class Plane implements Vehicles {
    @Override
    public void work() {
        System.out.println("plan work...");
    }
}

class VehiclesFactory {
    // 马儿始终是同一匹
    private static Horse horse = new Horse();  // 饿汉式

    private VehiclesFactory() {
    }

    // 这里将方法做成 static，便于调用
    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Plane getPlan() {
        return new Plane();
    }

}

class Person {
    private String name;
    private Vehicles vehicles;

    // 在创建Person对象时，
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    // 实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    // 这里可以把具体的要求封装成方法发
    // 如何不浪费，在构建对象时，传入的交通工具对象
    public void passRiver() {
//        Boat boat = VehiclesFactory.getBoat();
//        boat.work();
//        if (vehicles == null) {
        // vehicles instanceof Boat 是判断当前的 vehicles 是不是 Boat
        // (1) vehicles = null : vehicles instanceof Boat => false => getBoat() => work()
        // (2) vehicles = Horse : vehicles instanceof Boat => false => getBoat() => work()
        // (1) vehicles = Boat : vehicles instanceof Boat => true => work()
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        // 判断一下，当前的 vehicles 属性是否是 null ，如果是 null，就获取一匹马
//        if (vehicles == null) {
        if (!(vehicles instanceof Horse)) {
            // 这里使用的是多态，向上转型
            vehicles = VehiclesFactory.getHorse();
        }
        // 这里体现使用接口调用
        vehicles.work();
    }

    public void passFireMountain() {
        if (!(vehicles instanceof Plane)) {
            vehicles = VehiclesFactory.getPlan();
        }
        vehicles.work();
    }
}


