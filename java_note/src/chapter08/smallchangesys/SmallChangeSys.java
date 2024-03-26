package chapter08.smallchangesys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 零钱通项目
 * <p>
 * 项目需求说明
 * 使用Java开发零钱通项目，可以完成收益入账，消费，查看明细，退出系统等功能.
 * <p>
 * 项目的界面
 * ---------------------零钱通菜单---------------------
 * 1 零钱通明细
 * 2 收益入账
 * 3 消   费
 * 4 退   出
 * 请选择(1-4)：1
 * ---------------------零钱通明细---------------------
 * 收益入账     +100    2024-03-26 15：31    余额：100.0
 * 收益入账     +100    2024-03-26 15：31    余额：100.0
 * 收益入账     +100    2024-03-26 15：31    余额：100.0
 */

public class SmallChangeSys {

    private String[] recordArr = {};
    private int operate;

    public static void main(String[] args) {

        String operate;
        double money;
        String note;  // 消费说明
        boolean loop = true;

        SmallChangeSys smallChangeSys = new SmallChangeSys();
        BankAccount bankAccount = new BankAccount();

        Scanner scanner = new Scanner(System.in);

//        System.out.println(smallChangeSys.dateTime());

        do {
            smallChangeSys.menu();
            operate = scanner.next();
            switch (operate) {
                case "1":
                    // select 1 零钱通明细
                    smallChangeSys.detail();
                    break;
                case "2":
                    // select 2 收益入账
                    System.out.print("请输入收益金额：");
                    money = scanner.nextDouble();
//                    while (!(smallChangeSys.isPositiveNumber(money))) {
//                        System.out.print("请重新输入收益金额：(输入金额数不能小于零)");
//                        money = scanner.nextDouble();
//                    }
                    //
                    if (!(smallChangeSys.isPositiveNumber(money))) {
                        System.out.print("money error...(输入金额数不能小于零)");
                        break;
                    }
                    smallChangeSys.income(bankAccount, money);
                    break;
                case "3":
                    // select 3 消   费
                    System.out.print("请输入消费金额：");
                    money = scanner.nextDouble();
//                    while (!(smallChangeSys.isPositiveNumber(money))) {
//                        System.out.print("请重新输入消费金额：(输入金额数不能小于零)");
//                        money = scanner.nextDouble();
//                    }
                    //
                    if (!(smallChangeSys.isPositiveNumber(money))) {
                        System.out.print("money error...(输入金额数不能小于零)");
                        break;
                    }
                    System.out.print("请输入消费说明：");
                    note = scanner.next();
                    smallChangeSys.spend(bankAccount, money, note);
                    break;
                case "4":
                    // select 4 退   出
                    // 再次确认
                    String choice = "";
//                    while (true) {
//                        System.out.print("你确定要退出么？y/n");
//                        choice = scanner.next();
//                        if (choice.equals("y")) {
//                            System.out.println("确定退出...");
//                            smallChangeSys.exit();
//                            loop = false;
//                            break;
//                        } else if (choice.equals("n")) {
//                            System.out.println("取消退出...");
//                            break;
//                        }
//                    }
                    // 尽量一段代码只实现一个逻辑，实现代码的解耦
                    while (true) {
                        System.out.print("你确定要退出么？y/n");
                        choice = scanner.next();
                        if (choice.equals("y") || choice.equals("n")) {
                            break;
                        }
                    }
                    if (choice.equals("y")) {
                        System.out.println("确定退出...");
                        loop = false;
                    } else if (choice.equals("n")) {
                        System.out.println("取消退出...");
                    }
                    break;
                default:
                    System.out.println("operate error...please select 1-4...");
            }
        } while (loop);

        System.out.println("已退出零钱通系统！");
    }

    /**
     * 零钱通菜单
     */
    public void menu() {
        System.out.print(
                "---------------------零钱通菜单---------------------\n" +
                        "\t\t\t\t\t1 零钱通明细\n" +
                        "\t\t\t\t\t2 收益入账\n" +
                        "\t\t\t\t\t3 消   费\n" +
                        "\t\t\t\t\t4 退   出\n" +
                        "请选择(1-4)："
        );
    }

    /**
     * 1 零钱通明细
     */
    public void detail() {
        System.out.println("---------------------零钱通明细---------------------");
        if (recordArr == null || recordArr.length == 0) {
            System.out.println("暂无记录...");
            return;
        }
        // 遍历 recordArr 数组
        for (int i = 0; i < recordArr.length; i++) {
            System.out.println(recordArr[i]);
        }
    }

    /**
     * 2 收益入账
     *
     * @param bA    : 需要知道是哪个账户的，所以需要传入一个账户对象
     * @param money : 收益入账的金额
     */
    public void income(BankAccount bA, double money) {
        System.out.println("---------------------收益入账---------------------");
        operate = 2;  // 表示收益入账操作
        // 存钱
        if (!(bA.deposit(money))) {
            System.out.println("收益入账操作失败...deposit error...");
            return;
        }
        // add deposit record
        if (!(record(operate, money, bA))) {
            System.out.println("收益入账操作失败...record error...");
            return;
        }
        System.out.println("收益入账操作成功...");
    }

    /**
     * 3 消   费
     *
     * @param bA    : 涉及账户
     * @param money : 涉及消费金额
     * @param brand : 消费说明
     */
    public void spend(BankAccount bA, double money, String brand) {
        System.out.println("---------------------消   费---------------------");
        operate = 3;  // 表示消费操作
        // 花钱，相当于取钱
        if (!(bA.withdraw(money))) {
            System.out.println("消费操作失败...withdraw error...");
            return;
        }
        // add spand record
        if (!(record(operate, money, bA, brand))) {
            System.out.println("消费操作失败...record error...");
            return;
        }
        System.out.println("消费操作成功...");
    }

    /**
     * 4 退   出
     */
    public void exit() {
        System.out.println("---------------------退   出---------------------");
    }

    /**
     * 需要用一个数组来存储每一笔操作记录的信息
     * 每调用一次该方法，就增加一条数据
     *
     * @param operate : 2 - 表示收益入账调用该方法；3 - 表示消费调用该方法
     * @param money   : 涉及金额数
     * @param bA      : 涉及账户对象
     * @param strings : 可变 String 参数，用来接收消费调用该方法时，传入的消费说明，收益入账调用该方法时，不需要传入该参数
     * @return : 该方法执行成功返回 true，执行失败返回 false
     */
    public boolean record(int operate, double money, BankAccount bA, String... strings) {
        if (operate != 2 && operate != 3) {
            System.out.println("operate error...please again...");
            return false;
        }
        // 创建一个新的数组，长度比原来的数组多一个
        if (recordArr == null) {
            recordArr = new String[]{};
        }
        String[] newRecordArr = new String[recordArr.length + 1];
        // 将就数组中的数据拷贝到新的数组中
        for (int i = 0; i < recordArr.length; i++) {
            newRecordArr[i] = recordArr[i];
        }
        // 还剩最后一个数据
        switch (operate) {
            case 2:  // operate = 2 表示收益入账操作
                newRecordArr[newRecordArr.length - 1] = (
                        "收益入账\t" + "+" + money + "\t" + dateTime() + "\t" + "余额：" + bA.getBalance()
                );
                break;
            case 3:  // operate = 3 表示消费操作
                String note = strings[0];  // 只取第一个可变变量的值
                newRecordArr[newRecordArr.length - 1] = (
                        note + "\t" + "-" + money + "\t" + dateTime() + "\t" + "余额：" + bA.getBalance()
                );
                break;
        }
        recordArr = newRecordArr;  // 将新的记录数组赋给旧的记录数组
        newRecordArr = null;  // 释放资源
        return true;
    }

    /**
     * 获取当前时间
     *
     * @return : 返回当前时间的字符串
     */
    public String dateTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /**
     * 判断输出的金额是否为一个正数，接受的金额数需要是一个正数
     *
     * @param money : 接收输入的金额数
     * @return : money 是正数，返回true，是负数，返回false
     */
    public boolean isPositiveNumber(double money) {
        if (money < 0) {
            System.out.println("money error...money not positive number...");
            return false;
        }
        return true;
    }
}

class BankAccount {

    private double balance;  // 余额

    public BankAccount() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(double balance) {
        this.setBalance(balance);
    }

    /**
     * 存款
     *
     * @param money : 存款金额
     * @return : 返回存款操作是否成功，成功返回true，失败返回false
     */
    public boolean deposit(double money) {
        this.setBalance(balance += money);
        return true;
    }

    /**
     * 取款
     *
     * @param money : 取款金额
     * @return : 返回取款操作是否成功，成功返回true，失败返回false
     */
    public boolean withdraw(double money) {
        if (getBalance() < money) {
            System.out.println("balance not enough...");
            return false;
        }
        this.setBalance(balance -= money);
        return true;
    }
}
