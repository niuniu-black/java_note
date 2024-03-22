package chapter07;

public class MiGong {

    public static void main(String[] args) {

        // 1.创建迷宫，用二维数组表示
        int[][] map = new int[8][7];
        System.out.println(map.length);
        System.out.println(map[0].length);
        // 2.先规定 map 数组的元素值：0 表示可以走，1 表示障碍物
        // 3.将最外围的四条边以及[3][1],[3][2]设置为障碍物
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;  // left
            map[i][map[i].length - 1] = 1;  // right
        }
        for (int i = 0; i < map[i].length; i++) {
            map[0][i] = 1;  // up
            map[map.length - 1][i] = 1;  // down
        }
        map[3][1] = 1;
        map[3][2] = 1;
        // 添加障碍物
        map[2][2] = 1;

        System.out.println("初始地图：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        T t1 = new T();
        t1.findWay(map, 1, 1);

        System.out.println("完成地图：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class T {

    // 使用递归回溯的思想来解决老鼠出迷宫

    // 1. findway 方法就是专门来找出迷宫的路径
    // 2. 如果找到，就返回 true ，否则返回 false
    // 3. map 就是二维数组，即表示迷宫
    // 4. i ， j 表示老鼠的位置，初始化的位置为(1,1)
    // 5.因为我们是递归找路，所以先规定 map 数组的各个值的含义
    //    0 表示未走过；1 表示障碍物；2 表示走过，可以走；3 表示走过，但是走不通
    // 6. map[6][5] 为迷宫出口，当 map[6][5] = 2 就说明找到通路，就可以结束，否则就
    // 7. 先确定老鼠找路策略 下 -> 右 -> 上 -> 左

    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 说明已经找到
            return true;
        } else {
            if (map[i][j] == 0) {  // 当前位置为0，说明可以走
                // 假定可以走通
                map[i][j] = 2;
                // 使用找路策略，来确定该位置是否真的可以走通
                // 下 -> 右 -> 上 -> 左
                if (findWay(map, i + 1, j)) {  // 下
                    return true;
                } else if (findWay(map, i, j + 1)) {  // 右
                    return true;
                } else if (findWay(map, i - 1, j)) {  // 上
                    return true;
                } else if (findWay(map, i, j - 1)) {  // 左
                    return true;
                } else {  // 四个方向都走不通
                    map[i][j] = 3;  // 设置为 3 ，表示走过，但是走不通
                    return false;
                }
            } else {  // map[i][j] = 1, 2, 3
                return false;
            }
        }
    }

}