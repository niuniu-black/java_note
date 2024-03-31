package chapter14.homework04;

public class Homework04  {

    /*
    简答题：
    试分析 HashSet 和 TreeSet 分别如何实现去重的？
    1、HashSet 的去重机制：hashCode() + equals() , 底层先通过存入对象，进行运算得到一个 hash 值，
    通过 hash 值得到对应的索引，如果发现 table 索引所在的位置，没有数据，就直接存放，如果有数据，就进行
    equals 比较[遍历比较]，如果比较后，不相同，就加入，否则就不加入。
    2、TreeSet 的去重机制：如果你传入了一个 Comparator 匿名对象，就使用实现的 compare 去重，如果
    方法返回0，就认为是相同的元素/数据，就不添加，如果你没有传入一个 Comparator 匿名对象，则以你添加
    的对象实现的 Comparable 接口的 compareTo 去重。
     */
}
