package by.sel;

import java.util.HashMap;
import java.util.Map;

/** 18. ����֮�� */
public class Q454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // ͳ�����������е�Ԫ��֮�ͣ�ͬʱͳ�Ƴ��ֵĴ���������map
        for (int i : nums1) {
            for (int j : nums2) {
                int key = i + j;
                int cur = map.getOrDefault(key, 0);
                map.put(key, cur + 1);
            }
        }
        // ͳ��ʣ�������Ԫ�صĺͣ���map�����Ƿ�������Ϊ0�������ͬʱ��¼����
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-(i + j), 0);
            }
        }
        return res;
    }
}
