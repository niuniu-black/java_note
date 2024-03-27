package chapter09.houserent.sevice;

import chapter09.houserent.domain.House;

/**
 * HouseService.java <=> 类 [业务层]
 * // 定义 House[] ，保存 House 对象
 * 1. 响应 HouseView 的调用
 * 2. 完成对房屋信息的各种操作(crud)
 */
public class HouseService {

    private House[] houses;  // 保存 House 对象
    private int houseNum = 1;  // 记录当前有多少个房屋信息
    private int idCount = 1;  // 记录当前的 id 增长到哪个值

    public HouseService(int size) {
        this.houses = new House[size];  // 当创建 HouseService 对象，指定数组大小
        // 为了配合测试列表信息，这里初始化一个 House 对象
        houses[0] = new House(1, "jack", "112", "海淀区", 2000, "未出租");
    }

    // add 方法，添加新对象，返回 boolean
    // TODO: 2024/3/27 暂时不考虑扩容问题
    public boolean add(House newHouse) {
        // 判断是否还可以继续添加
        if (houseNum == houses.length) {  // 不能再添加
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        // 继续添加
        houses[houseNum++] = newHouse;
        // 设计一个 id 自增器
        newHouse.setId(++idCount);
        return true;
    }

    // del 方法，删除一个房屋信息
    // TODO: 2024/3/27 删除房屋后，可以考虑编号是否要重新设置顺序
    public boolean del(int delId) {
        // 应当先找到要删除的房屋信息对应的下标
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }

        if (index == -1) {  // 说明 delId 在数组中不存在
            return false;
        }

        // 如果找到，
        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        // 把当前存在的房屋信息的最后一个，设置为 null
        houses[--houseNum] = null;
        return true;
    }

    // findById 方法，根据 id 查找房屋信息
    public House findById(int findId) {

        for (int i = 0; i < houseNum; i++) {
            if (findId == houses[i].getId()) {
                // 如果找到，返回对应 house 对象
                return houses[i];
            }
        }
        return null;

    }

    // revise 方法，修改房屋信息
    public void revise(House newHouse, House oldHouse) {
        // 将 newHouse 的信息设置给 oldHouse
        oldHouse.setName(newHouse.getName());
        oldHouse.setPhone(newHouse.getPhone());
        oldHouse.setAddress(newHouse.getAddress());
        oldHouse.setRent(newHouse.getRent());
        oldHouse.setState(newHouse.getState());
    }

    // list 方法，返回 houses
    public House[] list() {
        return houses;
    }
}
