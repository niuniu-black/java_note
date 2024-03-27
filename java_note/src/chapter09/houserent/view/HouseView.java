package chapter09.houserent.view;

import chapter09.houserent.domain.House;
import chapter09.houserent.sevice.HouseService;
import chapter09.houserent.utils.Utility;

import javax.rmi.CORBA.Util;

/**
 * 1. 显示界面
 * 2. 接受用户输入
 * 3. 调用 HouseService 完成对房屋信息的各种操作
 */
public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);  // 设置数组的大小为10

    // 显示主菜单
    public void mainMenu() {

        do {
            System.out.println("------------------房屋出租系统------------------");
            System.out.println("\t\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退       出");
            System.out.print("请选择(1-6)：");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    loop = false;
                    break;
            }
        } while (loop);
    }

    // 1 编写 addHouse() 增加房屋
    public void addHouse() {
        System.out.println("------------------添加房屋------------------");
//        System.out.print("姓名：");
//        String name = Utility.readString(8);  // 读取输入字符串，长度不超过8
//        System.out.print("电话：");
//        String phone = Utility.readString(12);
//        System.out.print("地址：");
//        String address = Utility.readString(16);
//        System.out.print("月租：");
//        double rent = Utility.readDouble(12);
//        System.out.print("状态(未出租/已出租)：");
//        String state = Utility.readString(3);

        // 创建一个新的 House 对象，注意 id 是系统分配的
//        House newHouse = new House(0, name, phone, address, rent, state);
        House newHouse = inputInfo();
        if (houseService.add(newHouse)) {
            System.out.println("------------------添加房屋成功------------------");
        } else {
            System.out.println("------------------添加房屋失败------------------");
        }
    }

    // 2 编写 findHouse() 实现根据 id 查找功能
    public void findHouse() {
        System.out.println("------------------查找房屋------------------");
        System.out.print("请输入你要查找id：");
        int findId = Utility.readInt();
        // 执行查询操作
        House house = houseService.findById(findId);
        if (house == null) {
            System.out.println("------------------房屋不存在------------------");
        } else {
            // 找到就输出对象信息
            System.out.println(house);
        }
    }

    // 3 编写 delHouse() 接收输入的id，调用 Service 的 del 方法
    public void delHouse() {
        System.out.println("------------------删除房屋------------------");
        System.out.print("请选择待删除房屋编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("------------------放弃删除房屋------------------");
            return;
        }

        char choice = Utility.readConfirmSelection();  // 注意该方法本身九有循环判断的逻辑，必须输入 Y/N
        if (choice == 'Y') {  // 确认删除，调用删除操作
            if (houseService.del(delId)) {
                System.out.println("------------------删除房屋成功------------------");
            } else {
                System.out.println("------------------房屋不存在，删除失败------------------");
            }
        } else {
            System.out.println("------------------放弃删除房屋------------------");
        }
    }

    // 4 编写 updateHouse() 接收输入的 id，根据找到的房屋修改
    public void updateHouse() {
        System.out.println("------------------修改房屋------------------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int reviseId = Utility.readInt();
        if (reviseId == -1) {
            System.out.println("------------------放弃修改房屋信息------------------");
            return;
        }
        // 需要先查找是否存在id对应的对象
        House house = houseService.findById(reviseId);
        if (house == null) {
            System.out.println("------------------房屋不存在------------------");
            return;
        }
        // 找到,再执行修改操作
        // 获取新的房屋信息
        System.out.print("姓名(" + house.getName() + ")：");
        // 读取输入字符串，长度不超过8,这里如果用户直接回车表示不修改该信息，默认""
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {  // 输入不为空，设置新名字
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {  // 输入不为空，设置新电话
            house.setName(phone);
        }

        System.out.print("地址(" + house.getAddress() + ")：");
        String address = Utility.readString(16, "");
        if (!"".equals(address)) {  // 输入不为空，设置新地址
            house.setName(address);
        }

        System.out.print("月租" + house.getRent() + "：");
        double rent = Utility.readDouble(-1);
        if (rent != -1) {
            house.setRent(rent);
        }

        System.out.print("状态(" + house.getState() + ")：");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {  // 输入不为空，设置新状态
            house.setName(state);
        }

        System.out.println("------------------修改完成------------------");
    }


    // 4 编写 reviseHouse() 接收输入的 id，根据找到的房屋修改，这个是自己的写法
    // 这里将键盘输入部分进行封装便于两个方法的调用
    public void reviseHouse() {
        System.out.println("------------------修改房屋------------------");
        System.out.print("请选择待修改房屋编号(-1退出)：");
        int reviseId = Utility.readInt();
        if (reviseId == -1) {
            System.out.println("------------------放弃修改房屋信息------------------");
            return;
        }
        // 需要先查找是否存在id对应的对象
        House house = houseService.findById(reviseId);
        if (house == null) {
            System.out.println("------------------房屋不存在------------------");
            return;
        }
        // 找到,再执行修改操作
        // 获取新的房屋信息
        House newHouse = inputInfo();
        // 调用修改方法
        houseService.revise(newHouse, house);
        System.out.println("------------------修改完成------------------");
    }

    // 5 编写 listHouses() 显示房屋列表
    public void listHouses() {
        System.out.println("--------------------房屋列表--------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();  // 得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("------------------房屋列表完成------------------");
    }

    // 6 编写 exit() 完成退出功能
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    // 接收键盘输入的房屋信息
    public House inputInfo() {
        System.out.print("姓名：");
        String name = Utility.readString(8);  // 读取输入字符串，长度不超过8
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        double rent = Utility.readDouble(12);
        System.out.print("状态(未出租/已出租)：");
        String state = Utility.readString(3);

        House house = new House(0, name, phone, address, rent, state);

        return house;
    }
}
