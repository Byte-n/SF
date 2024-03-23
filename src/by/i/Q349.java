package by.i;

import java.util.Arrays;

/** 349. 两个数组的交集 */
public class Q349 {

    // 哈希表
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        题目规定了
        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000
         */
        int[] counts = new int[1000];
        for (int i : nums1) {
            if (counts[i] == 0) {
                counts[i] = 1;
            }
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int i : nums2) {
            if (counts[i] == 1) {
                counts[i] = 0;
                res[k++] = i;
            }
        }
        return Arrays.copyOf(res, k);
    }

    // 双指针
    public int[] intersection2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = Math.min(len1, len2);
        int[] ans = new int[len];
        if (len1 == 0 || len2 == 0) {  // 处理边界条件
            return ans;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 排序后，按顺序比较
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                // 答案需要去重
                if (k == 0 || ans[k - 1] != nums1[i]) {
                    ans[k++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }
}
