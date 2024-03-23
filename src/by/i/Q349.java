package by.i;

import java.util.Arrays;

/** 349. ��������Ľ��� */
public class Q349 {

    // ��ϣ��
    public int[] intersection(int[] nums1, int[] nums2) {
        /*
        ��Ŀ�涨��
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

    // ˫ָ��
    public int[] intersection2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = Math.min(len1, len2);
        int[] ans = new int[len];
        if (len1 == 0 || len2 == 0) {  // ����߽�����
            return ans;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // ����󣬰�˳��Ƚ�
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                // ����Ҫȥ��
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
