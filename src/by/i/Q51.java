package by.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 51. N 皇后 */
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
     * 回溯
     *
     * @param res  存储结果
     * @param path 当前路径 = 棋盘上已有皇后的坐标
     * @param row  当前第几行
     * @param n    总共有几行
     */
    static void backtracking(List<List<String>> res, int[][] path, int row, int n) {
        // 最后一行
        if (row == n) {
            // 转换、存储结果
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
        例如：n = 4, ;
        开始枚举当前 可能的位置：
        第一行 row = 0 的皇后的位置可能是：(0,0),(0,1),(0,2),(0,3)
         */
        for (int i = 0; i < n; i++) {
            // 判断当前层是否合法
            if (!check(path, row, i)) {
                /*
                不合法则就直接跳过
                例如 path = [0,0], row = 1
                此时 (1,0) 坐标，和 path 中已有的坐标有冲突，后续在此基础上的 row =2、3 自然也错误
                 */
                continue;
            }
            // 落子
            path[row] = new int[]{row, i};
            // 递归
            backtracking(res, path, row + 1, n);
            // 回溯: 回到落子前的状态
            path[row] = null;
        }
    }

    static boolean check(int[][] path, int curRow, int curCol) {
        // 遍历已有的坐标
        for (int[] xy : path) {
            if (xy == null) {
                continue;
            }
            int x = xy[0];
            int y = xy[1];
            // 横坐标、纵坐标，有一个相同则G
            if (x == curRow || y == curCol) {
                return false;
            }
            // 以(curRow,curCol)为点，四个对角方向
            if (Math.abs(curRow - x) == Math.abs(curCol - y)) {
                return false;
            }
        }
        return true;
    }

}
