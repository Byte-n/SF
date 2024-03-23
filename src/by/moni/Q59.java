package by.moni;

import java.util.Arrays;

public class Q59 {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public static int[][] generateMatrix(int n) {
        // 1 2 3
        // 8 9 4
        // 7 6 5
        // 拆分为
        // 1 2
        // 3 6
        // 8 9
        // 7 4
        // 5

        // 1  2  3  4
        // 12 13 14 5
        // 11 16 15 6
        // 10 9  8  7
        // 拆分为
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // 10 11 12
        // 13
        // 14
        // 15
        // 16
        // 最外层的循环控制，如上图拆解，3 时，循环一次，4 时循环 两次
        int loop = 0;
        int maxLoop = n / 2;

        int val = 1;
        int limit = 1;
        int[][] res = new int[n][n];

        while (loop < maxLoop) {
            // 每一轮的开始位置： 0,0     1,1    2,2
            int x = loop;
            int y = loop;

            // limit 和 n 控制 循环次数。例如 n 为 4 时，第一层的值为 1,2,3 (循环三次) 第二层为 13 （循环一次）
            for (int i = 0; i < n - limit; i++) {
                res[x][y++] = val++;
            }

            for (int i = 0; i < n - limit; i++) {
                res[x++][y] = val++;
            }

            for (int i = 0; i < n - limit; i++) {
                res[x][y--] = val++;
            }

            for (int i = 0; i < n - limit; i++) {
                res[x--][y] = val++;
            }
            // 注意是 +2。例如 n 为 4 时，第一层的值为 1,2,3 (循环三次) 第二层为 13 （循环一次），递减值是2
            limit += 2;
            loop++;
        }

        // 单数时，需要 单独处理 中心
        if (n % 2 != 0) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }
}
