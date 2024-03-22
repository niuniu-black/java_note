package chapter07;

public class HanoiTower {

    public static void main(String[] args) {

        Tower tower = new Tower();
        tower.move(3, 'A', 'B', 'C');
    }
}

class Tower {

    // num 表示要移动的个数， a, b, c 分别表示A塔，B塔，C塔
    public void move(int num, char a, char b, char c) {
        // 如果只有一个盘子 num = 1
        if (num == 1) {
            System.out.println(a + " -> " + c);
        } else {
            // 如果有多个盘子，可以看成两个，最下面的和剩余上面所有的盘子(num-1)
            // (1) 先移动上面所有的盘子到 b，借助 c
            move(num - 1, a, c, b);
            // (2) 把最下面的盘子，移动到 c
            System.out.println(a + " -> " + c);
            // (3) 再把 b塔的所有盘子，移动到 c，借助 a
            move(num - 1, b, a, c);
        }
    }
}