package chapter17.homework01;

import java.util.Scanner;

/*
1.编程题 Homework01.java 5min
(1)在main方法中启动两个线程
(2)第1个线程循环随机打印100以内的整数
(3)直到第2个线程从键盘读取了“Q”命令
 */
public class Homework01 {

    public static void main(String[] args) {

        A a = new A();
        B b = new B(a);

        a.start();
        b.start();
    }
}

class A extends Thread {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A exit...");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {

    A a = null;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("put in : ");
            String str = scanner.next().toUpperCase();
            if (str.equals("Q")) {
                a.setLoop(false);
                System.out.println("B exit...");
                break;
            }
        }
    }
}
