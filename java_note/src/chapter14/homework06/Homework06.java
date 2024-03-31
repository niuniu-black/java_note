package chapter14.homework06;

import java.util.HashSet;
import java.util.Objects;

/*
6.下面的代码输出什么? 老韩提示:这道题很有意思，稍不注意就掉进陷阱.
已知: Person类按照id和name重写了hashCode和equals方法,问下面代码输出什么?
HashSet set = new HashSet();
Person p1 = new Person(1001,"AA");
Person p2 = new Person(1002,"BB");
set.add(p1);
set.add(p2);
p1.name = "CC";
set.remove(p1);
System.out.println(set);
set.add(new Person(1001,"CC"));
System.out.println(set);
set.add(new Person(1001,"AA"));
System.out.println(set);

print:
{1002="BB"}
{1002="BB", 1001="CC"}
{1002="BB", 1001="AA"}
 */
@SuppressWarnings({"all"})
public class Homework06 {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);  // p1 的 name 已经被改变，所以此时 p1 的地址和原 p1 的地址可能已经不同，所以，原 p1 不会被删除
        System.out.println(set);  // 输出2个对象
        set.add(new Person(1001, "CC"));
        System.out.println(set);  // 输出3个对象
        set.add(new Person(1001, "AA"));
        System.out.println(set);  // 输出4个对象
    }
}

class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
