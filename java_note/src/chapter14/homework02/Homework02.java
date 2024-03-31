package chapter14.homework02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
2.编程题
使用ArrayList完成对对象Car {name, price}的各种操作
1.add:添加单个元素
2.remove:删除指定元素
3.contains:查找元素是否存在
4.size:获取元素个数
5.isEmpty:判断是否为空
6.clear:清空
7.addAll:添加多个元素
8.containsAll:查找多个元素是否都存在
9.removeAll:删除多个元素
使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
Car car = new Car("宝马"，400000);
Car car2 = new Car("宾利"，5000000);
 */
@SuppressWarnings({"all"})  // 抑制警告
public class Homework02 {

    public static void main(String[] args) {

        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        ArrayList arrayList = new ArrayList();
        // 1.add:添加单个元素
        arrayList.add(car);
        arrayList.add(car2);
        System.out.println(arrayList);
        // 2.remove:删除指定元素
        arrayList.remove(car);
//        arrayList.remove(1);
        System.out.println(arrayList);
        // 3.contains:查找元素是否存在
        System.out.println(arrayList.contains(car));
        // 4.size:获取元素个数
        System.out.println(arrayList.size());
        // 5.isEmpty:判断是否为空
        System.out.println(arrayList.isEmpty());
        // 6.clear:清空
//        arrayList.clear();
        System.out.println(arrayList);
        // 7.addAll:添加多个元素
        arrayList.addAll(arrayList);
        System.out.println(arrayList);
        // 8.containsAll:查找多个元素是否都存在
        System.out.println(arrayList.containsAll(arrayList));
        // 9.removeAll:删除多个元素
//        arrayList.removeAll(arrayList);
        System.out.println(arrayList);
        // 使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
        System.out.println("=====增强for循环输出=====");
        for (Object o : arrayList) {
            System.out.println(o.toString());
        }

        System.out.println("=====迭代器输出=====");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

    }
}

class Car {
     private String name;
     private double price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
