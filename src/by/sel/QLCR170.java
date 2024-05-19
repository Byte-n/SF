package by.sel;

import java.util.Arrays;
import java.util.Collections;

public class QLCR170 {

    public int reversePairs(int[] record) {
        if (record.length <= 1) {
            return 0;
        }

        return mergeSort(record, 0, record.length - 1, 0);
    }

    public static void main(String[] args) {
        int[] ints = {7, 5, 6, 4, 2};
        int total = mergeSort(ints, 0, ints.length - 1, 0);
        System.out.println("total = " + total);
    }

    public static int mergeSort(int[] nums, int left, int right, int level) {
        // 终止条件
        if (left >= right) {
            return 0;
        }
        // 分组
        int mid = (left + right) / 2;
        int total = mergeSort(nums, left, mid, level + 1) + mergeSort(nums, mid + 1, right, level + 1);

        /*
        tempArr: [5, 6, 7, 2, 4]
                  l        r
                           m
         */
        int[] tempArr = Arrays.copyOfRange(nums, left, right + 1);
        int l = 0, m = (tempArr.length + 1) / 2, r = m;
        for (int k = left; k <= right; k++) {

            if (l == m) {
                nums[k] = tempArr[r];
                r++;
                continue;
            }

            if (r == tempArr.length) {
                nums[k] = tempArr[l];
                l++;
                continue;
            }

            int lVal = tempArr[l], rVal = tempArr[r];

            if (lVal <= rVal) {
                nums[k] = lVal;
                l++;
                continue;
            }

            nums[k] = rVal;
            r++;
            /*
            例如：
            [5, 6, 7, 2, 4]
             l        r
                      m
            temp[l]=5 > temp[l]=2, 且 [l,m)、 [m,temp.length) 删都是单调递增的
            则区间[l,m)上的数都大于 temp[r]
             */
            // 在 r 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
            total += (m - l);
        }
        return total;
    }
}
