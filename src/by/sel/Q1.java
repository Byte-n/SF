package by.sel;

import java.util.HashMap;

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int c = target - num;
            if (map.containsKey(c)) {
                return new int[]{i, map.get(c)};
            }
            map.put(num, i);
        }
        return null;
    }
}
