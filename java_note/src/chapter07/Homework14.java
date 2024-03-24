package chapter07;

import java.util.Random;
import java.util.Scanner;

public class Homework14 {

    /*
    14.扩展题,学员自己做.
    有个人Tom设计他的成员变量.成员方法,可以电脑猜拳.电脑每次都会随机生成0,1,2
    0表示石头1表示剪刀2表示布并要可以显示Tom的输赢次数(清单)
     */

    public static void main(String[] args) {

        Tom tom = new Tom();
        Scanner scanner = new Scanner(System.in);
        int myOperate;
        int myWinCount = 0;
        int myLoseCount = 0;

        System.out.println("石头剪子布游戏开始...");
        while (true) {
            // tom 出
            tom.play();

            System.out.println("tom 已出完，该你出了...(0-石头, 1-剪刀, 2-布, 9-退出)");
            myOperate = scanner.nextInt();

            switch (myOperate) {
                case 0:
                    System.out.println("你出的是石头...");
                    break;
                case 1 :
                    System.out.println("你出的是剪刀...");
                    break;
                case 2 :
                    System.out.println("你出的是布...");
                    break;
                case 9 :
                    System.out.println("游戏结束...");
                    return;
                default:
                    System.out.println("operate error...please select 0, 1, 2 or 9\n");
                    System.out.println("================================================================\n");
                    continue;
            }

            switch (tom.getOperate()) {
                case 0 :
                    System.out.println("tom 出的是石头...");
                    break;
                case 1 :
                    System.out.println("tom 出的是剪刀...");
                    break;
                case 2 :
                    System.out.println("tom 出的是布...");
                    break;
                default:
                    System.out.println("tom error...");
            }

            if (tom.getOperate() - myOperate == 0) {
                System.out.println("你和tom出的一样，平手...");
            } else if (tom.getOperate() - myOperate == -1 || tom.getOperate() - myOperate == 2) {
                System.out.println("tom win...you lose...");
                tom.win();
                myLoseCount++;
            } else if (tom.getOperate() - myOperate == -2 || tom.getOperate() - myOperate == 1) {
                System.out.println("you win...tom lose...");
                tom.lose();
                myWinCount++;
            } else {
                System.out.println("error...");
                return;
            }

            System.out.println("----------------------------------------------------------------\n" +
                    "当前胜负情况：\t\t胜\t\t负\n" +
                    "你\t\t\t\t" + myWinCount + "\t\t" + myLoseCount + "\n" +
                    "tom\t\t\t\t" + tom.getWinCount() + "\t\t" + tom.getLoseCount() + "\n" +
                    "----------------------------------------------------------------\n"
            );

            System.out.println("================================================================\n");
        }
    }
}

class Tom {

    int winCount;
    int loseCount;
    int operate;

    public Tom() {
        this.winCount = 0;
        this.loseCount = 0;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public void setLoseCount(int loseCount) {
        this.loseCount = loseCount;
    }

    public void setOperate(int operate) {
        this.operate = operate;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public int getOperate() {
        return operate;
    }

    public void win() {
        this.setWinCount(winCount + 1);
    }

    public void lose() {
        this.setLoseCount(loseCount + 1);
    }

    public void play() {  // 随机生成0,1,2
//        this.setOperate((int)(Math.random() * 3));
        Random random = new Random();
        this.setOperate(random.nextInt(3));
        System.out.println("========" + this.operate);
    }
}
