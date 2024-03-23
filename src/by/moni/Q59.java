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
        // ���Ϊ
        // 1 2
        // 3 6
        // 8 9
        // 7 4
        // 5

        // 1  2  3  4
        // 12 13 14 5
        // 11 16 15 6
        // 10 9  8  7
        // ���Ϊ
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // 10 11 12
        // 13
        // 14
        // 15
        // 16
        // ������ѭ�����ƣ�����ͼ��⣬3 ʱ��ѭ��һ�Σ�4 ʱѭ�� ����
        int loop = 0;
        int maxLoop = n / 2;

        int val = 1;
        int limit = 1;
        int[][] res = new int[n][n];

        while (loop < maxLoop) {
            // ÿһ�ֵĿ�ʼλ�ã� 0,0     1,1    2,2
            int x = loop;
            int y = loop;

            // limit �� n ���� ѭ������������ n Ϊ 4 ʱ����һ���ֵΪ 1,2,3 (ѭ������) �ڶ���Ϊ 13 ��ѭ��һ�Σ�
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
            // ע���� +2������ n Ϊ 4 ʱ����һ���ֵΪ 1,2,3 (ѭ������) �ڶ���Ϊ 13 ��ѭ��һ�Σ����ݼ�ֵ��2
            limit += 2;
            loop++;
        }

        // ����ʱ����Ҫ �������� ����
        if (n % 2 != 0) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }
}
