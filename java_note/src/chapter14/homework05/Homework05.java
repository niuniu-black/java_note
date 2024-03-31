package chapter14.homework05;

import java.util.TreeSet;

@SuppressWarnings({"all"})
public class Homework05 {

    /*
    代码分析题：
    下面代码运行会不会抛出异常，并从源码层面说明原因。[考察 读源码+接口编程+动态绑定]
     */

    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        // 分析源码
        // add 方法，因为 TreeSet() 构造器没有传入 Comparator 接口的匿名内部类
        // 所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        // 即 把 Person 转成 Comparable 类型
        treeSet.add(new Person());  // 会报 ClassCastException
        // 解决方法，在 Person 实现 Comparable 接口
    }
}

class Person implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
