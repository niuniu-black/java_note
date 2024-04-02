package chapter17.homework02;

/*
2.编程题
(1)有2个用户分别从同一个卡上取钱(总额:10000)
(2)每次都取1000,当余额不足时，就不能取款了
(3)不能出现超取现象 =》 线程同步问题,
 */
public class Homework02 {

    public static void main(String[] args) {

        T t = new T();
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t);

        thread1.setName("t1");
        thread2.setName("t2");

        thread1.start();
        thread2.start();

//        Bank bank = new Bank(10000);
//        A a = new A(bank);
//        B b = new B(bank);
//
//        a.start();
//        b.start();
    }
}

// 1. 因为这涉及到多个线程共享资源，所以我们使用实现 Runnable 接口的方式
class T implements Runnable {
    private double money = 10000;

    @Override
    public void run() {
        while (true) {

            // 解读：
            // 1. 这里使用了 synchronized 实现了线程同步
            // 2. 当多个线程执行这段代码时，就会去争夺 this 对象锁
            // 3. 哪个线程争夺到(获取)this 对象锁，就执行 synchronized 代码快，执行完后，会释放 this 对象锁
            // 4. 争夺不到 this 对象锁，就 blocked ，准备继续争夺
            // 5. this 对象锁是非公平锁
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("money not enough...");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取走1000，账户还剩：" + money);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " thread exit...");
    }
}

//
class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void withdrawal(double money) {
        balance -= money;
    }

    public double getBalance() {
        return balance;
    }
}

class A extends Thread {
    private boolean loop = true;
    private double money = 1000;
    Bank bank = null;

    public A(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (loop) {
            if (bank.getBalance() < money) {
                System.out.println("A say : balance not enough...");
                break;
            }
            bank.withdrawal(money);
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(getName() + " - A取走1000，账户还剩：" + bank.getBalance());
        }
        System.out.println("A exit...");
    }
}

class B extends Thread {
    private boolean loop = true;
    private double money = 1000;
    Bank bank = null;

    public B(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (loop) {
            if (bank.getBalance() < money) {
                System.out.println("B say : balance not enough...");
                break;
            }
            bank.withdrawal(money);
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(getName() + " - B取走1000，账户还剩：" + bank.getBalance());
        }
        System.out.println("B exit...");
    }
}
