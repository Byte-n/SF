package by.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 51. N �ʺ� */
public class Q51 {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>(n);
        int[][] path = new int[n][];
        backtracking(res, path, 0, n);
        return res;
    }

    /**
     * ����
     *
     * @param res  �洢���
     * @param path ��ǰ·�� = ���������лʺ������
     * @param row  ��ǰ�ڼ���
     * @param n    �ܹ��м���
     */
    static void backtracking(List<List<String>> res, int[][] path, int row, int n) {
        // ���һ��
        if (row == n) {
            // ת�����洢���
            ArrayList<String> list = new ArrayList<>(n);
            for (int[] val : path) {
                int y = val[1];
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[y] = 'Q';
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }
        /*
        ���磺n = 4, ;
        ��ʼö�ٵ�ǰ ���ܵ�λ�ã�
        ��һ�� row = 0 �Ļʺ��λ�ÿ����ǣ�(0,0),(0,1),(0,2),(0,3)
         */
        for (int i = 0; i < n; i++) {
            // �жϵ�ǰ���Ƿ�Ϸ�
            if (!check(path, row, i)) {
                /*
                ���Ϸ����ֱ������
                ���� path = [0,0], row = 1
                ��ʱ (1,0) ���꣬�� path �����е������г�ͻ�������ڴ˻����ϵ� row =2��3 ��ȻҲ����
                 */
                continue;
            }
            // ����
            path[row] = new int[]{row, i};
            // �ݹ�
            backtracking(res, path, row + 1, n);
            // ����: �ص�����ǰ��״̬
            path[row] = null;
        }
    }

    static boolean check(int[][] path, int curRow, int curCol) {
        // �������е�����
        for (int[] xy : path) {
            if (xy == null) {
                continue;
            }
            int x = xy[0];
            int y = xy[1];
            // �����ꡢ�����꣬��һ����ͬ��G
            if (x == curRow || y == curCol) {
                return false;
            }
            // ��(curRow,curCol)Ϊ�㣬�ĸ��ԽǷ���
            if (Math.abs(curRow - x) == Math.abs(curCol - y)) {
                return false;
            }
        }
        return true;
    }

}
