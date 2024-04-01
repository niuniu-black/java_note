package chapter15.homework01;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
编程题
定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为T 类型
分别创建以下方法:
(1)public void save(String id,T entity): 保存T类型的对象到 Map 成员变量中
(2)public T get(String id): 从 map 中获取 id 对应的对象
(3) public void update(String id,T entity):替换 map 中key为id的内容,改为 entity 对象
(4) public List<T> list():返回 map 中存放的所有 T 对象
(5)public void delete(String id): 删除指定 id 对象

定义一个 User 类:
该类包含:private成员变量(int类型)id，age;(String 类型)name.

创建 DAO 类的对象，分别调用其 save、get、update、list、delete 方法来操作 User 对象
使用 Junit 单元测试类进行测试。
 */
public class Homework01 {

    public static void main(String[] args) {

    }

    @Test
    public void testDao() {
        // 这里我们给 T 指定类型时 User
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(1, 19, "jack"));
        dao.save("002", new User(2, 18, "tom"));
        dao.save("003", new User(3, 20, "jerry"));

        List<User> list = dao.list();
        System.out.println(list);

        User user = dao.get("002");
        System.out.println(user);

        dao.update("001", new User(1, 15, "king"));
        System.out.println(dao.list());

        dao.delete("003");
        System.out.println(dao.list());
    }

}

class DAO<T> {

    private Map<String, T> map = new HashMap<>();

    public DAO() {
    }

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    // 保存T类型的对象到 Map 成员变量中
    public void save(String id,T entity) {
        map.put(id, entity);
    }

    // 从 map 中获取 id 对应的对象
    public T get(String id) {
        return map.get(id);
    }

    // 替换 map 中key为id的内容,改为 entity 对象
    public void update(String id,T entity) {
        map.put(id, entity);
    }

    // 返回 map 中存放的所有 T 对象
    public List<T> list() {
        // 创建 ArrayList
        List<T> list = new ArrayList<>();

        // 遍历 map
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }

        return list;
    }

    // 删除指定 id 对象
    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private  int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
