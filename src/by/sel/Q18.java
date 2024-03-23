package by.sel;

import java.util.*;

public class Q18 {
    public static void main(String[] args) {
        fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000, -1000000000, -1000000000, -1000000000, -1000000000}, 0);
    }

    // 双指针 || 哈希表
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        int length = nums.length;
        long m2 = nums[length - 1] * 2L;
        long m3 = m2 + nums[length - 1];
        for (int i = 0; i < length - 3; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) continue;
            // 4个最小的a都大于target则跳过
            // 以 a 开始，后续的 b、c、d 肯定都 大于等于 a，则有如下关系
            // target < 4 * a <= a + b + c + d
            if (a * 4L > target) break;

            // 如果当前 a + 最大的三个数，都小于 0，则跳过当前 a
            // 以 a 开始，后续的 b、c、d 肯定都小于等于 m(数组的最后一位)
            // target < a + m * 3 <= a + b + c + d
            if ((long) a + m3 < target) continue;

            // if ((long) a + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) { break; }
            // if ((long) a + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) { continue; }

            for (int j = i + 1; j < length - 2; j++) {
                int b = nums[j];
                if (j > i + 1 && b == nums[j - 1]) continue;
                if ((long) a + b * 3L > target) break;
                if ((long) a + b + m2 < target) continue;

                // if ((long) a + b + nums[j + 1] + nums[j + 2] > target) { break; }
                // if ((long) a + b + nums[length - 2] + nums[length - 1] < target) { continue; }

                /*HashSet<Integer> dSet = new HashSet<>();
                for (int k = j + 1; k < length; k++) {
                    int c = nums[k];
                    int sum = a + b + c;
                    int d = target - sum;
                    if (dSet.contains(d)) {
                        // 溢出检查
                        if ((long) target != (long) a + b + c + d) {
                            dSet.remove(d);
                            continue;
                        }
                        result.add(Arrays.asList(a, b, c, d));
                        dSet.remove(d);
                        while (k < length - 1 && nums[k] == nums[k + 1]) {
                            k++;
                        }
                    } else {
                        dSet.add(c);
                    }
                }*/

                int left = j + 1; // c
                int right = nums.length - 1; // d
                while (right > left) {
                    long sum = (long) a + b + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    }
                    // 等于 target
                    else {
                        result.add(Arrays.asList(a, b, nums[left], nums[right]));
                        // 注意别越界
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
